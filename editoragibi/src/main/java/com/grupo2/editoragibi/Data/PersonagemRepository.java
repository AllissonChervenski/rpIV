package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IPersonagemRepository personagemRepository;

    public Optional<Personagem> getPersonagemById(int id) {

        Optional<PersonagemEntity> personagemEntity = personagemRepository.findById(id);

        if (!personagemEntity.isPresent())
            return Optional.empty();

        Personagem personagem = mapPersonagem(personagemEntity.get());

        return Optional.of(personagem);
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

        PersonagemEntity personagemEntity = modelMapper.map(personagem, PersonagemEntity.class);

        List<Escritor> escritores = personagem.getEscritores();

        List<EscritorEntity> escritoresEntity = escritores.stream().map(escritor -> {
            return modelMapper.map(escritor, EscritorEntity.class);
        }).collect(Collectors.toList());

        personagemEntity.setEscritores(escritoresEntity);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        Personagem toReturn = modelMapper.map(personagemToReturn, Personagem.class);

        toReturn.setEscritores(escritores);

        return toReturn;
    }

    public void deletePersonagem(int id) {

        personagemRepository.deleteById(id);
    }

    public Personagem updatePersonagem(int id, Personagem personagem) {

        if (personagemRepository.findById(id).isEmpty())
            return null;

        personagem.setPersonagemId(id);

        PersonagemEntity personagemEntity = modelMapper.map(personagem, PersonagemEntity.class);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        return modelMapper.map(personagemToReturn, Personagem.class);
    }
}