package com.uk.xyzassessment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uk.xyzassessment.controller.AggregationController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AggregationController.class) // Import the controller to include it in the test context
public class TestConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
