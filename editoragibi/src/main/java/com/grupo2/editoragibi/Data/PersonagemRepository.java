package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.IBasePersonagemBuilder;
import com.grupo2.editoragibi.Service.Builders.PersonagemBuilder;
import com.grupo2.editoragibi.Service.Builders.PersonagemEntityBuilder;
import com.grupo2.editoragibi.Service.Directors.PersonagemDirector;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    private IBasePersonagemBuilder personagemBuilder = new PersonagemBuilder();
    private IBasePersonagemBuilder personagemEntityBuilder = new PersonagemEntityBuilder();
    private PersonagemDirector personagemDirector = new PersonagemDirector(personagemBuilder);
    private PersonagemDirector personagemEntityDirector = new PersonagemDirector(personagemEntityBuilder);

    @Autowired
    IPersonagemRepository personagemRepository;

    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException {

        Optional<PersonagemEntity> personagemEntity = personagemRepository.findById(id);

        if (!personagemEntity.isPresent())
            throw new PersonagemInvalidoException("Personagem não está no sistema");

        BasePersonagem personagem = personagemDirector.buildFromPersonagemEntity(personagemEntity.get());

        return (Personagem) personagem;
    }

    public List<Personagem> getPersonagens() throws PersonagemInvalidoException {

        List<PersonagemEntity> personagensEntity = personagemRepository.findAll();

        List<Personagem> personagens = new ArrayList<>();
        for (PersonagemEntity personagem : personagensEntity) {
            personagens.add((Personagem) personagemDirector.buildFromPersonagemEntity(personagem));
        }

        return personagens;
    }

    public Personagem addPersonagem(Personagem personagem) throws PersonagemInvalidoException {

        PersonagemEntity personagemEntity = (PersonagemEntity) personagemEntityDirector.buildFromPersonagem(personagem);
        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);
        return (Personagem) personagemDirector.buildFromPersonagemEntity(personagemToReturn);
    }

    public boolean deletePersonagem(int id) {

        if (personagemRepository.findById(id).isEmpty())
            return false;

        personagemRepository.deleteById(id);
        return true;
    }

    public Personagem updatePersonagem(int id, Personagem personagem) throws PersonagemInvalidoException {

        if (personagemRepository.findById(id).isEmpty())
            throw new PersonagemInvalidoException("Personagem não está no sistema");

        personagem.setPersonagemId(id);

        PersonagemEntity personagemEntity = (PersonagemEntity) personagemEntityDirector.buildFromPersonagem(personagem);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        return (Personagem) personagemDirector.buildFromPersonagemEntity(personagemToReturn);
    }
}