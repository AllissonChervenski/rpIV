package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Service.Builders.*;
import com.grupo2.editoragibi.Service.Directors.BancaDirector;
import com.grupo2.editoragibi.Service.Directors.EscritorDirector;
import com.grupo2.editoragibi.Service.Directors.PersonagemDirector;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    //banca beans
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

    //escritor beans

    @Bean(name = "escritorDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    EscritorDirector getEscritorDirector(EscritorBuilder escritorBuilder) {
        return new EscritorDirector(escritorBuilder);
    }

    @Bean(name = "escritorEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    EscritorDirector getEscritorEntityDirector(EscritorEntityBuilder escritorEntityBuilder) {
        return new EscritorDirector(escritorEntityBuilder);
    }

    //personagem beans

    @Bean(name = "personagemDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    PersonagemDirector getPersonagemDirector(PersonagemBuilder personagemBuilder) {
        return new PersonagemDirector(personagemBuilder);
    }

    @Bean(name = "personagemEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    PersonagemDirector getPersonagemEntityDirector(PersonagemEntityBuilder personagemEntityBuilder) {
        return new PersonagemDirector(personagemEntityBuilder);
    }

    //TODO
    //tenho que mudar as beans pra que retorne o builder em vez da director
}
