package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.Support.VisitorToEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    @Autowired
    IPersonagemRepository personagemRepository;

    @Autowired
    VisitorToEntity visitorToEntity;

    @Autowired
    ModelMapper modelMapper;

    public Optional<Personagem> getPersonagemById(int id) throws PersonagemInvalidoException {

        Optional<PersonagemEntity> personagemEntity = personagemRepository.findById(id);

        if (!personagemEntity.isPresent())
            throw new PersonagemInvalidoException("Personagem não está no sistema");

        Personagem personagemToReturn = mapPersonagem(personagemEntity.get());

        return Optional.of(personagemToReturn);
    }

    public List<Personagem> getPersonagens() {

        List<PersonagemEntity> personagens = personagemRepository.findAll();

        return personagens.stream().map(personagem -> {
            return mapPersonagem(personagem);
        }).collect(Collectors.toList());
    }

    private Personagem mapPersonagem(PersonagemEntity personagemEntity) {

        Personagem personagem = modelMapper.map(personagemEntity, Personagem.class);

        List<Escritor> escritores = personagemEntity.getEscritores().stream().map(escritor -> {
            return modelMapper.map(escritor, Escritor.class);
        }).collect(Collectors.toList());

        personagem.setEscritores(escritores);

        return personagem;
    }

    public Personagem addPersonagem(Personagem personagem) {

        List<Escritor> escritores = personagem.getEscritores();

        PersonagemEntity personagemEntity = visitorToEntity.personagemToEntity(personagem);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        Personagem toReturn = mapPersonagem(personagemToReturn);

        return toReturn;
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

        PersonagemEntity personagemEntity = visitorToEntity.personagemToEntity(personagem);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        return mapPersonagem(personagemToReturn);
    }
}