package com.paydala.common.cache;

public interface CacheService {
    void setObjectAsString(String key, String value);

    String getObjectAsString(String key);

    void setObjectAsString(String key, String value, int ttl);

    Object getObject(String key);

    void setObject(String key, Object obj);
}
