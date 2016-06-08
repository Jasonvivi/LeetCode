package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jason on 16/6/8.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>()
        {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                if(cache.size() > capacity)
                    return true;
                return false;
            }
        };
    }

    public int get(int key) {
        int value = -1;
        if(cache.containsKey(key))
        {
            value = cache.get(key);
            moveToFront(key,value);
        }
        return value;
    }

    public void set(int key, int value)
    {
        if(cache.containsKey(key))
            cache.remove(key);
        cache.put(key,value);
    }
    private void moveToFront(int key, int value)
    {
        cache.remove(key);
        cache.put(key, value);
    }
}
