package com.grupo2.editoragibi.Config.gibiconfigs;


import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.GibiRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GibConfig {

    @Bean
    CommandLineRunner commandLineRunner(GibiRepository repository){
        return args -> {
            GibiEntity flash = new GibiEntity(
                    "flash",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)

            );
            GibiEntity sm = new GibiEntity(
                    "SM",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)

            );

            GibiEntity bat = new GibiEntity(
                    "Batman",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)
            );

            repository.saveAll(List.of(flash,sm, bat));
        };
    }
}
