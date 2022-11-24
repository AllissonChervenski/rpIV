package com.grupo2.editoragibi.Config.gibiconfigs;


import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IGibiRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GibConfig {

    @Bean
    CommandLineRunner commandLineRunner(IGibiRepository repository){
        return args -> {
            GibiEntity flash = new GibiEntity(
                    "flash",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3), "sim"

            );
           
            GibiEntity sm = new GibiEntity(
                    "SM",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3), null
                    

            );

            GibiEntity bat = new GibiEntity(
                    "Batman",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3), "Não"
            );

            GibiEntity sup = new GibiEntity(
                "Superman", 
                LocalDate.of(1999, Month.JANUARY, 1),
                LocalDate.of(2020, Month.JANUARY, 3), "Não"
        );

            repository.saveAll(List.of(flash,sm, bat,sup));
        };
    }
}
