package com.etiya.customer.management.core.ccc.caching;

public class RedisCaching implements ICaching{
    @Override
    public void cache(String key, Object data) {
        System.out.println("Redis ile cachelendi..");
    }

    @Override
    public void cacheBroke(String key) {
        System.out.println("Redis ile cache broke edildi..");
    }

    @Override
    public Object get(String key) {
        return null;
    }
}
