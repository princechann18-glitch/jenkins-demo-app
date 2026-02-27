package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoApplication - Main entry point for the Jenkins Demo Spring Boot application
 * 
 * This class serves as the primary configuration and startup point for the Spring Boot application.
 * It enables component scanning, auto-configuration, and property file support.
 * 
 * Features:
 * - Automatic Spring configuration
 * - Component scanning in com.example.demo package
 * - Embedded Tomcat server configuration
 * - REST controller mapping
 * 
 * Usage:
 * Run this class directly to start the Spring Boot application.
 * The application will be available at http://localhost:8080
 * 
 * @author Demo Team
 * @version 1.0
 * @since 2026-02-27
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * Main method - Entry point for Spring Boot application
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}