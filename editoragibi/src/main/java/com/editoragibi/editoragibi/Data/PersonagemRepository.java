package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.PersonagemEntity;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonagemRepository {

    @Autowired
    IPersonagemRepository personagemRepository;

    public PersonagemEntity getPersonagemById(int id) throws PersonagemInvalidoException, EscritorInvalidoException {
        Optional<PersonagemEntity> personagemEntity = personagemRepository.findById(id);
        if (!personagemEntity.isPresent())
            throw new PersonagemInvalidoException("Personagem não está no sistema");
        return personagemEntity.get();
    }

    public List<PersonagemEntity> getPersonagens() throws PersonagemInvalidoException, EscritorInvalidoException {
        return personagemRepository.findAll();
    }

    public PersonagemEntity addPersonagem(PersonagemEntity personagemEntity) throws PersonagemInvalidoException, EscritorInvalidoException {
        return personagemRepository.save(personagemEntity);
    }

    public boolean deletePersonagem(int id) {

        if (personagemRepository.findById(id).isEmpty())
            return false;

        personagemRepository.deleteById(id);
        return true;
    }

    public PersonagemEntity updatePersonagem(int id, PersonagemEntity personagemEntity) throws PersonagemInvalidoException, EscritorInvalidoException {
        if (personagemRepository.findById(id).isEmpty())
            throw new PersonagemInvalidoException("Personagem não está no sistema");
        personagemEntity.setPersonagemId(id);
        return personagemRepository.save(personagemEntity);
    }
}