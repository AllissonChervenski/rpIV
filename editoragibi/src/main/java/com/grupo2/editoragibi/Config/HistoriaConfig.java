package com.grupo2.editoragibi.Config;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
/*import com.grupo2.editoragibi.Data.HistoriaRepository;*/
import com.grupo2.editoragibi.Data.IHistoriaRepository;
/*import com.grupo2.editoragibi.Service.Domain.Historia;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*import javax.persistence.Column;
import java.time.LocalDate;*/

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
