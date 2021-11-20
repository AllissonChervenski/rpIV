package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.IDesenhistaRepository;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesenhistaService {

    @Autowired
    DesenhistaRepository desenhistaRepository;

    public Desenhista getDesenhistaById(int id) {

        Optional<Desenhista> desenhista = desenhistaRepository.getDesenhistaById(id);

        if (!desenhista.isPresent())
            return null;

        return desenhista.get();
    }

    public Desenhista addDesenhista(Desenhista desenhista) {

        return desenhistaRepository.addDesenhista(desenhista);
    }
}
