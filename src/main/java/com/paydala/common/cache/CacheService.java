package com.paydala.common.cache;

public interface CacheService {
    void setObjectAsString(String key, String value);

    String getObjectAsString(String key);
}
