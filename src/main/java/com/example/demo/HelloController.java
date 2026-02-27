package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * HelloController - REST controller for the Jenkins Demo Application
 * 
 * This controller provides HTTP endpoints for the demo application.
 * It demonstrates basic REST API functionality and Spring MVC mapping.
 * 
 * Features:
 * - RESTful endpoint design
 * - JSON response format
 * - Health check endpoint
 * - CI/CD demonstration endpoint
 * 
 * Endpoints:
 * - GET /hello - Returns CI/CD greeting message
 * - GET /health - Returns application health status
 * 
 * @author Demo Team
 * @version 1.0
 * @since 2026-02-27
 */
@RestController
public class HelloController {

    /**
     * Hello endpoint - Returns a CI/CD demonstration message
     * 
     * This endpoint demonstrates basic REST API functionality.
     * It returns a JSON response with a greeting message.
     * 
     * @return Map containing the greeting message
     */
    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello CI/CD");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        response.put("application", "jenkins-demo-app");
        return response;
    }

    /**
     * Health check endpoint - Returns application health status
     * 
     * This endpoint is useful for monitoring and load balancer checks.
     * It returns the current application status and uptime information.
     * 
     * @return Map containing health status information
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "jenkins-demo-app");
        response.put("version", "1.0-SNAPSHOT");
        response.put("uptime", Runtime.getRuntime().totalMemory());
        return response;
    }

}