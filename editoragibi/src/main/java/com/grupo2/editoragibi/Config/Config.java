package com.grupo2.editoragibi.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
