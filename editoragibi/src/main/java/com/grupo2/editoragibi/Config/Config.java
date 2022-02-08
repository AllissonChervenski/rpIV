package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Service.Builders.*;
import com.grupo2.editoragibi.Service.Directors.*;
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
    BancaDirector getBancaDirector(BancaBuilder bancaBuilder) {
        return new BancaDirector(bancaBuilder);
    }

    @Bean(name = "bancaEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    BancaDirector getBancaEntityDirector(BancaEntityBuilder bancaEntityBuilder) {
        return new BancaDirector(bancaEntityBuilder);
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

    //desenhista beans

    @Bean(name = "desenhistaDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    DesenhistaDirector getDesenhistaDirector(DesenhistaBuilder desenhistaBuilder) {
        return new DesenhistaDirector(desenhistaBuilder);
    }

    @Bean(name = "desenhistaEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    DesenhistaDirector getDesenhistEntityDirector(DesenhistaEntityBuilder desenhistaEntityBuilder) {
        return new DesenhistaDirector(desenhistaEntityBuilder);
    }

    //historia beans

    @Bean(name = "historiaDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    HistoriaDirector getHistoriaDirector(HistoriaBuilder historiaBuilder) {
        return new HistoriaDirector(historiaBuilder);
    }

    @Bean(name = "historiaEntityDirector")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    HistoriaDirector getHistoriaEntityDirector(HistoriaEntityBuilder historiaEntityBuilder) {
        return new HistoriaDirector(historiaEntityBuilder);
    }
}
