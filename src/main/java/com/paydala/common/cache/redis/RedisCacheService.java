package com.paydala.common.cache.redis;

import com.paydala.common.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService implements CacheService {

    private final RedisUtil<String> redisStringUtil;

    @Autowired
    public RedisCacheService(RedisUtil<String> redisStringUtil) {
        this.redisStringUtil = redisStringUtil;
    }

    @Override
    public void setObjectAsString(String key, String value) {
        redisStringUtil.putValue(key, value);
        redisStringUtil.setExpire(key, 1, TimeUnit.HOURS);
    }

    @Override
    public String getObjectAsString(String key) {
        return redisStringUtil.getValue(key);
    }
}
