package gov.saanjh.user.service;

import gov.saanjh.user.domain.*;
import gov.saanjh.user.exception.BadRequestException;
import gov.saanjh.user.exception.ResourceNotFoundException;
import gov.saanjh.user.repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    RedisService redisService;

    @Autowired
    EmailService emailService;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Optional<User> user = userRepository.findByEmail(loginRequestDTO.getEmail());
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found !");
        }
        if (passwordEncoder.matches(loginRequestDTO.getPassword(), user.get().getPassword())) {
            return LoginResponseDTO.builder()
                    .idToken(jwtTokenUtil.generateToken(user.get()))
                    .refreshToken(jwtTokenUtil.generateRefreshToken(user.get()))
                    .message("Login successful !")
                    .build();
        }
        throw new BadRequestException("Invalid Credentials !");
    }

    public String logout(String jwtToken) {
        if (jwtTokenUtil.isTokenExpired(jwtToken)) {
            log.info("token expired");
            return "User logout Successful!";
        }
        redisService.deleteDataFromRedis(jwtTokenUtil.getUserIdFromToken(jwtToken));
        return "User Profile LoggedOut Successfully!!";
    }

    public String initiateForgotPassword(String username, Model model) throws MessagingException {
        String otp = generateOTP();
        emailService.sendEmail(EmailRequestDTO.builder()
                        .emailAddress(username)
                        .emailType(EmailType.FORGOT_PASSWORD)
                        .otp(otp)
                .build(), model
        );
        redisService.saveDataToRedis(username, generateOTP());
        return "Password forgot mail has been sent";
    }

    public String confirmNewPassword(String username, String newPassword, String confirmationCode) {
        String redisOtp = (String) redisService.getDataFromRedis(username);
        if (confirmationCode.equals(redisOtp)){
            Optional<User> user = userRepository.findByEmail(username);
            if(user.isEmpty()){
                throw new ResourceNotFoundException("User not found with the email address "+ username);
            }
            user.get().setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user.get());
        }
        return "Password Changed successfully !";
    }

    public static String generateOTP() {
        Random random = new Random();
        return String.valueOf(100000 + random.nextInt(900000));
    }

    public Boolean validateToken(String token) {
        return jwtTokenUtil.validateToken(token);
    }
}
