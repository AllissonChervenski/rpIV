package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Data.Support.VisitorToEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public VisitorToEntity getVititorToEntity() {
        return new VisitorToEntity();
    }

    @Bean ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
