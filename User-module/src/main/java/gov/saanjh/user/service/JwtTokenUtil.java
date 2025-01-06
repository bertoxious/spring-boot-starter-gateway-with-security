package gov.saanjh.user.service;



import gov.saanjh.user.domain.User;
import gov.saanjh.user.domain.UserClaims;
import gov.saanjh.user.exception.BadRequestException;
import gov.saanjh.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.*;
import java.util.*;
import java.util.function.Function;

@Component
@Slf4j
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.user.token.validity.sec: 259200}") // Defaults to 3 days
    public long JWT_USER_TOKEN_VALIDITY_IN_SEC;
    @Value("${jwt.secret}")
    private String secret;
    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * retrieves username (HprIdNumber/subject) from JWT Token
     *
     * @param token contains JWT Token
     * @return String
     */
    public String getUsernameFromToken(String token) {
        log.info("getUsernameFromToken :: extracting username from JWT Token");
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * retrieve expiration date from jwt token
     *
     * @param token contains jwt token
     * @return Date
     */
    public Date getExpirationDateFromToken(String token) {
        log.info("getExpirationDateFromToken :: retrieve expiration date from jwt token");
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * retrieve userType date from jwt token
     *
     * @param token contains jwt token
     * @return String
     */
    public String getUserIdFromToken(String token) {
        log.info("getUserTypeFromToken :: retrieve userType date from jwt token");
        final Claims claims = getAllClaimsFromToken(token);
        return (String) claims.get(UserClaims.userId.name());
    }

    /**
     * gets claims from token
     *
     * @param token          contains jwt token
     * @param claimsResolver contains higher order function
     * @param <T>            generic type
     * @return generic type
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        log.info("getClaimFromToken :: gets claims from token");
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * retrieving all claims from token
     *
     * @param token contains jwt token
     * @return Claims
     */
    private Claims getAllClaimsFromToken(String token) {
        log.info("getAllClaimsFromToken :: retrieving all claims from token");
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new BadRequestException("Access Code Expired !");
        }
        return claims;
    }

    /**
     * check if the token has expired
     *
     * @param token contains jwt token
     * @return Boolean
     */
    public Boolean isTokenExpired(String token) {
        log.info("isTokenExpired :: check if the token has expired GC");
        final Date expiration = getExpirationDateFromToken(token);
        log.info("expiration " + expiration);
        return expiration.before(new Date());
    }

//    public Boolean validateToken(String token, UserDetails userDetails) {
//        log.info("validateToken :: validating jwt token");
//        final String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }

    public String generateToken(User user) {
        HashMap<String,Object> claims = new HashMap<>();
        claims.put(UserClaims.userType.name(), user.getType());
        claims.put(UserClaims.name.name(), user.getFirstName());
        claims.put(UserClaims.email.name(), user.getEmail());
        claims.put(UserClaims.userId.name(), user.getId());
        return doGenerateToken(claims, String.valueOf(user.getId()));
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return doGenerateToken(claims, subject, JWT_USER_TOKEN_VALIDITY_IN_SEC * 1000);
    }

    private String doGenerateToken(Map<String, Object> claims, String subject, long duration) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .signWith(key).compact();
    }
    public String generateRefreshToken(User user) {
        // Minimal claims for the refresh token
        Map<String, Object> claims = new HashMap<>();
        claims.put(UserClaims.email.name(), user.getEmail());
        claims.put(UserClaims.userType.name(), user.getType());

        // Refresh token validity (e.g., 7 days)
        long refreshTokenValidity = 7 * 24 * 60 * 60 * 1000L; // 7 days in milliseconds

        return doGenerateToken(claims, user.getEmail(), refreshTokenValidity);
    }
}