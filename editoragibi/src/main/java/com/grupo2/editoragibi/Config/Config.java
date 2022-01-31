package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Service.Builders.PersonagemBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {

    @Bean ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
