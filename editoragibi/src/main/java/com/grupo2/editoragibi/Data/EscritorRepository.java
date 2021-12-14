package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 55afae3 (implementação do padrão visitor)
import com.grupo2.editoragibi.Data.Support.VisitorToEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
<<<<<<< HEAD
=======
import com.grupo2.editoragibi.Service.Domain.Escritor;
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EscritorRepository {

    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    IEscritorRepository escritorRepository;

    @Autowired
    VisitorToEntity visitorToEntity;

    @Autowired
    ModelMapper modelMapper;

    public Optional<Escritor> getEscritorById(int id) throws EscritorInvalidoException {
=======
    ModelMapper modelMapper;
=======
    IEscritorRepository escritorRepository;
>>>>>>> 55afae3 (implementação do padrão visitor)

    @Autowired
    VisitorToEntity visitorToEntity;

    @Autowired
    ModelMapper modelMapper;

<<<<<<< HEAD
    public Optional<Escritor> getEscritorById(int id) {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public Optional<Escritor> getEscritorById(int id) throws EscritorInvalidoException {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        Optional<EscritorEntity> escritorEntity = escritorRepository.findById(id);

        if (!escritorEntity.isPresent())
<<<<<<< HEAD
<<<<<<< HEAD
            throw new EscritorInvalidoException("Escritor não está no sistema");

        Escritor escritor = modelMapper.map(escritorEntity.get(), Escritor.class);

        escritor.setPersonagens(escritorEntity.get().getPersonagens().stream().map(personagem -> {
            return modelMapper.map(personagem, Personagem.class);
        }).collect(Collectors.toList()));
=======
            return Optional.empty();

        Escritor escritor = modelMapper.map(escritorEntity, Escritor.class);
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
            throw new EscritorInvalidoException("Escritor não está no sistema");

        Escritor escritor = modelMapper.map(escritorEntity.get(), Escritor.class);

        escritor.setPersonagens(escritorEntity.get().getPersonagens().stream().map(personagem -> {
            return modelMapper.map(personagem, Personagem.class);
        }).collect(Collectors.toList()));
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        return Optional.of(escritor);
    }

    public List<Escritor> getEscritores() {

        List<EscritorEntity> escritorEntity = escritorRepository.findAll();

        return escritorEntity.stream().map(escritor -> {
            return modelMapper.map(escritor, Escritor.class);
        }).collect(Collectors.toList());
    }

    public Escritor addEscritor(Escritor escritor) {

<<<<<<< HEAD
<<<<<<< HEAD
        EscritorEntity escritorEntity = visitorToEntity.escritorToEntity(escritor);
=======
        EscritorEntity escritorEntity = modelMapper.map(escritor, EscritorEntity.class);
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
        EscritorEntity escritorEntity = visitorToEntity.escritorToEntity(escritor);
>>>>>>> 55afae3 (implementação do padrão visitor)

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return modelMapper.map(escritorToReturn, Escritor.class);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public boolean deleteEscritor(int id) {

        if (escritorRepository.findById(id).isEmpty())
            return false;

        escritorRepository.deleteById(id);
        return true;
    }

    public Escritor updateEscritor(int id, Escritor escritor) throws EscritorInvalidoException {

        if (escritorRepository.findById(id).isEmpty())
            throw new EscritorInvalidoException("Escritor não está no sistema");

        escritor.setEscritorId(id);

        EscritorEntity escritorEntity = visitorToEntity.escritorToEntity(escritor);
<<<<<<< HEAD
=======
    public void deleteEscritor(int id) {

        escritorRepository.deleteById(id);
    }

    public Escritor updateEscritor(int id, Escritor escritor) {
=======
    public boolean deleteEscritor(int id) {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        if (escritorRepository.findById(id).isEmpty())
            return false;

        escritorRepository.deleteById(id);
        return true;
    }

    public Escritor updateEscritor(int id, Escritor escritor) throws EscritorInvalidoException {

        if (escritorRepository.findById(id).isEmpty())
            throw new EscritorInvalidoException("Escritor não está no sistema");

        escritor.setEscritorId(id);

        EscritorEntity escritorEntity = modelMapper.map(escritor, EscritorEntity.class);
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
>>>>>>> 55afae3 (implementação do padrão visitor)

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return modelMapper.map(escritorToReturn, Escritor.class);
    }
}
