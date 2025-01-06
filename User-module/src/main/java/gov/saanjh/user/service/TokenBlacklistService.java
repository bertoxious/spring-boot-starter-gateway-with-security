package gov.saanjh.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class TokenBlacklistService {

    private static final String BLACKLIST_PREFIX = "blacklisted_token:";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

     public void blacklistToken(String tokenId) {
        redisTemplate.opsForValue().set(BLACKLIST_PREFIX + tokenId, "true", Duration.ofHours(1));
         log.info("token blacklisted");

     }

    // Check if a token is blacklisted
    public boolean isTokenBlacklisted(String tokenId) {
        return redisTemplate.hasKey(BLACKLIST_PREFIX + tokenId);
    }
}
