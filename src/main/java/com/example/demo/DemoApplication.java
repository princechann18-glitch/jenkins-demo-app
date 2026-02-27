package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoApplication - Main Spring Boot Application Class
 * 
 * This is the entry point for the Jenkins Demo CI/CD application.
 * The @SpringBootApplication annotation enables auto-configuration,
 * component scanning, and allows defining additional beans on the class.
 * 
 * When the application starts, SpringApplication.run() will bootstrap
 * the entire Spring context and start an embedded Tomcat server.
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * Main method - entry point of the Spring Boot application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}