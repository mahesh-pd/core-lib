package com.paydala.common.cache.redis;

import com.paydala.common.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService implements CacheService {

    private final RedisUtil<String> redisStringUtil;
    private final RedisUtil<Object> redisObjectUtil;

    @Autowired
    public RedisCacheService(RedisUtil<String> redisStringUtil, RedisUtil<Object> redisObjectUtil) {
        this.redisStringUtil = redisStringUtil;
        this.redisObjectUtil = redisObjectUtil;
    }

    @Override
    public void setObjectAsString(String key, String value) {
        redisStringUtil.putValue(key, value);
        redisStringUtil.setExpire(key, 1, TimeUnit.HOURS);
    }

    @Override
    public void setObjectAsString(String key, String value, int ttl) {
        redisStringUtil.putValue(key, value);
        redisStringUtil.setExpire(key, ttl, TimeUnit.SECONDS);
    }

    @Override
    public void setObject(String key, Object obj) {
        redisObjectUtil.putValue(key, obj);
        redisStringUtil.setExpire(key, 1, TimeUnit.HOURS);
    }

    @Override
    public Object getObject(String key) {
        return redisObjectUtil.getValue(key);
    }

    @Override
    public String getObjectAsString(String key) {
        return redisStringUtil.getValue(key);
    }
}
