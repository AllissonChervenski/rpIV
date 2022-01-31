package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Service.Builders.BancaBuilder;
import com.grupo2.editoragibi.Service.Builders.BancaEntityBuilder;
import com.grupo2.editoragibi.Service.Directors.BancaDirector;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "bancaDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    BancaDirector getBancaDirector() {
        return new BancaDirector(new BancaBuilder());
    }

    @Bean(name = "bancaEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    BancaDirector getBancaEntityDirector() {
        return new BancaDirector(new BancaEntityBuilder());
    }
}
