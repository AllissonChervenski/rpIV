package com.grupo2.editoragibi.Data.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IGibiRepository;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

@Repository
public class GibiRepository {

    @Autowired
    IGibiRepository iGibiRepository;

    public Optional<GibiEntity> getGibiById(Integer id) throws GibiInvalidoException{
        Optional<GibiEntity> gibis = iGibiRepository.findById(id);
        
        return gibis;
    }

    public List<GibiEntity> getGibis() throws GibiInvalidoException{
        

        return iGibiRepository.findAll();
    }

    public Optional<GibiEntity> getGibiByTitulo(String titulo) throws GibiInvalidoException{
       
        return iGibiRepository.findGibiByTitulo(titulo);
    }

    public GibiEntity addGibi(GibiEntity gibi){
        return iGibiRepository.save(gibi);
    }

    public boolean deleteGibi(Integer id){

        if(iGibiRepository.findById(id).isEmpty()){
            return false;
        }
        iGibiRepository.deleteById(id);
        return true;
    }

    public GibiEntity updateGibi(Integer id, GibiEntity gibi) throws GibiInvalidoException{
        if(iGibiRepository.findById(id).isEmpty()){
            throw new GibiInvalidoException("Gibi não encontrado");
        }
        gibi.setGibi_id(id);
        return iGibiRepository.save(gibi);
    }


}




