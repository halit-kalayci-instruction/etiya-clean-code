package com.etiya.customer.management.core.ccc.caching;

public interface ICaching {
    void cache(String key,Object data);
    void cacheBroke(String key);
    Object get(String key);
}
