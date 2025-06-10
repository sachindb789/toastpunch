package com.dencotoast.toastpunch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public Map<String, Object> getTestData() {
        return Map.of(
                "message", "Hello from Toast Punch API!",
                "status", "success",
                "data", List.of("Item 1", "Item 2", "Item 3")
        );
    }
}
