package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.GibiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EdicoesGibiConfig {

    @Bean
    CommandLineRunner edicoesGibiConfiguration(EdicoesGibiRepository edicoesGibiRepository, GibiRepository gibiRepository){
        return  args -> {
            EdicoesGibi primeira = new EdicoesGibi(
                    1,
                    LocalDate.of(2000, Month.APRIL, 02)
            );

            EdicoesGibi segunda  = new EdicoesGibi(
                    2,
                    LocalDate.of(2000, Month.APRIL, 20)
            );
            edicoesGibiRepository.saveAll(List.of(primeira, segunda));
        };
    }
}
