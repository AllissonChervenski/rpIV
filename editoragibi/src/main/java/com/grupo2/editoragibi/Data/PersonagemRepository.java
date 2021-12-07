package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
<<<<<<< HEAD
import com.grupo2.editoragibi.Data.Support.VisitorToEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
=======
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
>>>>>>> f2e5813 (crud de escritor e personagem)
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import javax.swing.text.html.Option;
=======
>>>>>>> f2e5813 (crud de escritor e personagem)
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    @Autowired
<<<<<<< HEAD
    IPersonagemRepository personagemRepository;

    @Autowired
    VisitorToEntity visitorToEntity;

    @Autowired
    ModelMapper modelMapper;

    public Optional<Personagem> getPersonagemById(int id) throws PersonagemInvalidoException {
=======
    ModelMapper modelMapper;

    @Autowired
    IPersonagemRepository personagemRepository;

    public Optional<Personagem> getPersonagemById(int id) {
>>>>>>> f2e5813 (crud de escritor e personagem)

        Optional<PersonagemEntity> personagemEntity = personagemRepository.findById(id);

        if (!personagemEntity.isPresent())
<<<<<<< HEAD
            throw new PersonagemInvalidoException("Personagem não está no sistema");

        Personagem personagemToReturn = mapPersonagem(personagemEntity.get());

        return Optional.of(personagemToReturn);
=======
            return Optional.empty();

        Personagem personagem = mapPersonagem(personagemEntity.get());

        return Optional.of(personagem);
>>>>>>> f2e5813 (crud de escritor e personagem)
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

<<<<<<< HEAD
        List<Escritor> escritores = personagem.getEscritores();

        PersonagemEntity personagemEntity = visitorToEntity.personagemToEntity(personagem);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        Personagem toReturn = mapPersonagem(personagemToReturn);
=======
        PersonagemEntity personagemEntity = modelMapper.map(personagem, PersonagemEntity.class);

        List<Escritor> escritores = personagem.getEscritores();

        List<EscritorEntity> escritoresEntity = escritores.stream().map(escritor -> {
            return modelMapper.map(escritor, EscritorEntity.class);
        }).collect(Collectors.toList());

        personagemEntity.setEscritores(escritoresEntity);

        PersonagemEntity personagemToReturn = personagemRepository.save(personagemEntity);

        Personagem toReturn = modelMapper.map(personagemToReturn, Personagem.class);

        toReturn.setEscritores(escritores);
>>>>>>> f2e5813 (crud de escritor e personagem)

        return toReturn;
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> f2e5813 (crud de escritor e personagem)
    }
}