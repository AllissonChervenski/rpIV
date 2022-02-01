package com.editoragibi.editoragibi.gibi;

import com.editoragibi.editoragibi.edicoes.EdicoesGibi;
import org.apache.tomcat.jni.Local;
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
            Gibi flash = new Gibi(
                    "flash",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)

            );
            Gibi sm = new Gibi(
                    "SM",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)

            );

            Gibi bat = new Gibi(
                    "Batman",
                    LocalDate.of(1999, Month.JANUARY, 1),
                    LocalDate.of(2000, Month.JANUARY, 3)
            );

            repository.saveAll(List.of(flash,sm, bat));
        };
    }
}
