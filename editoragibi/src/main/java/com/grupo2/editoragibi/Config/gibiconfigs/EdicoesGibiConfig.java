package com.grupo2.editoragibi.Config.gibiconfigs;


import com.grupo2.editoragibi.Data.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EdicoesGibiConfig {

    @Bean
    CommandLineRunner edicoesGibiConfiguration(EdicoesGibiRepository edicoesGibiRepository){
        return  args -> {
            EdicoesGibiEntity primeira = new EdicoesGibiEntity(
                    1,
                    LocalDate.of(2000, Month.APRIL, 02)
            );

            EdicoesGibiEntity segunda  = new EdicoesGibiEntity(
                    2,
                    LocalDate.of(2000, Month.APRIL, 20)
            );
            edicoesGibiRepository.saveAll(List.of(primeira, segunda));
        };
    }
}
