package com.cache.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class KeyValueService {
    
    private static final int MAX_CACHE_SIZE = 1000; // Cache size limit

    private final Map<String, String> cache = Collections.synchronizedMap(new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > MAX_CACHE_SIZE; // Evict oldest entry if cache exceeds limit
        }
    });

    public Map<String, String> put(Map<String, String> request) {
        String key = request.get("key");
        String value = request.get("value");

        if (key == null || value == null || key.length() > 256 || value.length() > 256) {
            return Map.of("status", "ERROR", "message", "Invalid key or value");
        }

        cache.put(key, value);
        return Map.of("status", "OK", "message", "Key inserted/updated successfully.");
    }

    public Map<String, String> get(String key) {
        if (!cache.containsKey(key)) {
            return Map.of("status", "ERROR", "message", "Key not found.");
        }
        return Map.of("status", "OK", "key", key, "value", cache.get(key));
    }
}