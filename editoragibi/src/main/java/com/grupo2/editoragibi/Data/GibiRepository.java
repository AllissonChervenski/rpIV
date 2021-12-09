package com.grupo2.editoragibi.Data;

import java.util.Optional;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Domain.Gibi;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GibiRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IGibiRepository gibiRepository;

    public Optional<Gibi> getGibiById(Integer id){

        Optional<GibiEntity> gibiEntity = gibiRepository.findById(id);

        if(!gibiEntity.isPresent()){
            return Optional.empty();
        }
        
        Gibi gibi = modelMapper.map(gibiEntity.get(), Gibi.class);
        return Optional.of(gibi);
    }

    public Gibi addGibi(Gibi gibi){
        GibiEntity gibiEntity = modelMapper.map(gibi, GibiEntity.class);
        GibiEntity gibiToReturn = gibiRepository.save(gibiEntity);

        return modelMapper.map(gibiToReturn, Gibi.class);
    }

    public boolean deleteGibi(Integer id){


        gibiRepository.deleteById(id);

        return true;
    }


    public Gibi updateGibi(Integer id, Gibi gibi){
        gibi.setId(id);

        return addGibi(gibi);
    }



}
