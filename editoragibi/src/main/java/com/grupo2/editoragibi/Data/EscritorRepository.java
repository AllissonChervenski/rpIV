package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Service.Domain.Escritor;
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

    public Optional<Escritor> getEscritorById(int id) {

        Optional<EscritorEntity> escritorEntity = escritorRepository.findById(id);

        if (!escritorEntity.isPresent())
            return Optional.empty();

        Escritor escritor = modelMapper.map(escritorEntity, Escritor.class);

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

    public void deleteEscritor(int id) {

        escritorRepository.deleteById(id);
    }

    public Escritor updateEscritor(int id, Escritor escritor) {

        if (escritorRepository.findById(id).isEmpty())
            return null;

        escritor.setEscritorId(id);

        EscritorEntity escritorEntity = modelMapper.map(escritor, EscritorEntity.class);

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return modelMapper.map(escritorToReturn, Escritor.class);
    }
}
