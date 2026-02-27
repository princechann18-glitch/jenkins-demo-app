package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

/**
 * DemoApplicationTests - Unit tests for the Jenkins Demo Application
 * 
 * This test class contains comprehensive unit tests for the Spring Boot application.
 * It uses MockMvc to perform HTTP requests without starting a real server.
 * 
 * Features:
 * - Spring Boot integration tests
 * - REST endpoint testing
 * - MockMvc for HTTP simulation
 * - JUnit 5 assertions
 * - Response validation
 * 
 * Test Coverage:
 * - Application context loading
 * - Hello endpoint functionality
 * - Health check endpoint
 * - Response format validation
 * - HTTP status codes
 * 
 * @author Demo Team
 * @version 1.0
 * @since 2026-02-27
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    /**
     * MockMvc instance for performing HTTP requests
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test: Application context loads successfully
     * 
     * Verifies that the Spring Boot application can start without errors
     * and the application context is properly initialized.
     * 
     * @throws Exception if the test fails
     */
    @Test
    void contextLoads() throws Exception {
        // This test passes if the application context loads successfully
    }

    /**
     * Test: Hello endpoint returns correct response
     * 
     * Verifies that the /hello endpoint:
     * - Returns HTTP 200 (OK) status
     * - Contains the expected greeting message
     * - Returns proper JSON response
     * 
     * @throws Exception if the test fails
     */
    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello CI/CD"))
                .andExpect(jsonPath("$.application").value("jenkins-demo-app"));
    }

    /**
     * Test: Health endpoint returns UP status
     * 
     * Verifies that the /health endpoint:
     * - Returns HTTP 200 (OK) status
     * - Contains the correct health status
     * - Returns valid JSON format
     * 
     * @throws Exception if the test fails
     */
    @Test
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.service").value("jenkins-demo-app"));
    }

    /**
     * Test: Hello endpoint returns required fields
     * 
     * Verifies that the /hello endpoint response contains all required fields:
     * - message
     * - timestamp
     * - application
     * 
     * @throws Exception if the test fails
     */
    @Test
    void testHelloEndpointHasAllFields() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.application").exists());
    }

    /**
     * Test: Health endpoint returns version information
     * 
     * Verifies that the /health endpoint includes version information
     * for monitoring and debugging purposes.
     * 
     * @throws Exception if the test fails
     */
    @Test
    void testHealthEndpointVersion() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version").value("1.0-SNAPSHOT"));
    }

    /**
     * Test: Invalid endpoint returns 404
     * 
     * Verifies that requests to non-existent endpoints properly return
     * HTTP 404 (Not Found) status code.
     * 
     * @throws Exception if the test fails
     */
    @Test
    void testInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/invalid"))
                .andExpect(status().isNotFound());
    }

}