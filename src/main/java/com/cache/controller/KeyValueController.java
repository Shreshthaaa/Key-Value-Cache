package com.cache.controller;

import com.cache.service.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class KeyValueController {

    @Autowired
    private KeyValueService keyValueService;

    @PostMapping("/put")
    public Map<String, String> put(@RequestBody Map<String, String> request) {
        return keyValueService.put(request);
    }

    @GetMapping("/get")
    public Map<String, String> get(@RequestParam String key) {
        return keyValueService.get(key);
    }
}