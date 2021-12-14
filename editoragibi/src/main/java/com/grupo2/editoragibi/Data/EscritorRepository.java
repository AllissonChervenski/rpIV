package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EscritorRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IEscritorRepository escritorRepository;

    public Optional<Escritor> getEscritorById(int id) throws EscritorInvalidoException {

        Optional<EscritorEntity> escritorEntity = escritorRepository.findById(id);

        if (!escritorEntity.isPresent())
            throw new EscritorInvalidoException("Escritor não está no sistema");

        Escritor escritor = modelMapper.map(escritorEntity.get(), Escritor.class);

        escritor.setPersonagens(escritorEntity.get().getPersonagens().stream().map(personagem -> {
            return modelMapper.map(personagem, Personagem.class);
        }).collect(Collectors.toList()));

        return Optional.of(escritor);
    }

    public List<Escritor> getEscritores() {

        List<EscritorEntity> escritorEntity = escritorRepository.findAll();

        return escritorEntity.stream().map(escritor -> {
            return modelMapper.map(escritor, Escritor.class);
        }).collect(Collectors.toList());
    }

    public Escritor addEscritor(Escritor escritor) {

        EscritorEntity escritorEntity = modelMapper.map(escritor, EscritorEntity.class);

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return modelMapper.map(escritorToReturn, Escritor.class);
    }

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

        EscritorEntity escritorEntity = modelMapper.map(escritor, EscritorEntity.class);

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return modelMapper.map(escritorToReturn, Escritor.class);
    }
}