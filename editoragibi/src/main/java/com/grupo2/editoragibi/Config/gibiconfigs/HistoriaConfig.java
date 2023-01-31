package com.grupo2.editoragibi.Config.gibiconfigs;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IHistoriaRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoriaConfig {

    @Bean
    CommandLineRunner historiaConfiguration(IHistoriaRepository ihistoriaRepository){
        return args -> {
            HistoriaEntity historiaEntity = new HistoriaEntity();
        ihistoriaRepository.save(historiaEntity);
        };
    }
}
