package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
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

    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException {

        Optional<Personagem> personagem = personagemRepository.getPersonagemById(id);

        return personagem.get();
    }

    public List<Personagem> getPersonagens() {

        return personagemRepository.getPersonagens();
    }

    public Personagem addPersonagem(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {

        addEscritor(personagem, escritoresIds);

        return personagemRepository.addPersonagem(personagem);
    }

    public void deletePersonagem(int id) throws PersonagemInvalidoException {

        if (!personagemRepository.deletePersonagem(id))
            throw new PersonagemInvalidoException("Personagem não está no sistema");
    }

    public Personagem updatePersonagem(int id, Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException, PersonagemInvalidoException {

        addEscritor(personagem, escritoresIds);

        return personagemRepository.updatePersonagem(id, personagem);
    }

    private void addEscritor(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {

        if (escritoresIds == null || escritoresIds.isEmpty())
            throw new EscritorInvalidoException("Personagem sem escritor associado");

        for (int id : escritoresIds) {

            Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

            if (escritor.isEmpty())
                throw new EscritorInvalidoException("Escritor não está no sistema");

            personagem.addEscritor(escritor.get());
        }
    }
}
