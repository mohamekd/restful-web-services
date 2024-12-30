package com.kood.restful_web_services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        // Create an ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Configure default filter behavior
        SimpleFilterProvider filters = new SimpleFilterProvider();
        filters.setFailOnUnknownId(false); // Allow serialization even without filter configuration

        mapper.setFilterProvider(filters);
        return mapper;
    }
}
