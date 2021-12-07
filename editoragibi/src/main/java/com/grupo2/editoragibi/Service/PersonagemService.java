package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    EscritorRepository escritorRepository;

    public Personagem getPersonagemById(int id) {

        Optional<Personagem> personagem = personagemRepository.getPersonagemById(id);

        if (personagem.isEmpty())
            return null;

        return personagem.get();
    }

    public List<Personagem> getPersonagens() {

        return personagemRepository.getPersonagens();
    }

    public Personagem addPersonagem(Personagem personagem, List<Integer> escritoresIds) throws Exception {

        addEscritor(personagem, escritoresIds);

        return personagemRepository.addPersonagem(personagem);
    }

    public boolean deletePersonagem(int id) {

        personagemRepository.deletePersonagem(id);

        return true;
    }

    public Personagem updatePersonagem(int id, Personagem personagem, List<Integer> escritoresIds) throws Exception {

        addEscritor(personagem, escritoresIds);

        return personagemRepository.updatePersonagem(id, personagem);
    }

    private void addEscritor(Personagem personagem, List<Integer> escritoresIds) throws Exception {

        if (escritoresIds == null || escritoresIds.isEmpty())
            throw new Exception("Sem escritor");

        for (int id : escritoresIds) {

            Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

            if (escritor.isEmpty())
                throw new Exception("Escritor invalido");

            personagem.addEscritor(escritor.get());
        }
    }
}
