package gov.saanjh.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class RedisService {
    private final ValueOperations<String, Object> valueOperations;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        valueOperations = redisTemplate.opsForValue();
    }

    public void saveDataToRedis(String key, Object value) {
        log.info("saveDataToRedis :: Key :: {} :: Value :: {} ", key, value);
        valueOperations.set(key, value, Duration.ofSeconds(100));
    }

    public Object getDataFromRedis(String key) {
        return valueOperations.get(key);
    }

    public void deleteDataFromRedis(String key) {
        redisTemplate.delete(key);
    }

}

