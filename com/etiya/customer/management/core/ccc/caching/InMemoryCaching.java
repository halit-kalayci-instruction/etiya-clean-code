package com.etiya.customer.management.core.ccc.caching;

import java.util.HashMap;

public class InMemoryCaching implements ICaching{
    private HashMap objects;

    public InMemoryCaching() {
        objects=new HashMap();
    }

    @Override
    public void cache(String key, Object data) {
        System.out.println(key + " verisi cacheleniyor..");
        objects.put(key,data);
    }

    @Override
    public void cacheBroke(String key) {
        objects.remove(key);
    }

    @Override
    public Object get(String key) {
        return objects.get(key);
    }
}
