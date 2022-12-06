package com.grupo2.editoragibi.Data.Repositories;

import java.util.List;
import java.util.Optional;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IGibiRepository;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

@Repository
public class GibiRepository {

    @Autowired
    IGibiRepository gibiRepository;

    public GibiEntity getGibiById(int id) throws GibiInvalidoException {
        Optional<GibiEntity> gibiEntity = gibiRepository.findById(id);
        if (!gibiEntity.isPresent())
            throw new GibiInvalidoException("Gibi não está no sistema");
        return gibiEntity.get();
    }

    public List<GibiEntity> getGibis() throws GibiInvalidoException {
        return gibiRepository.findAll();
    }

    public GibiEntity addGibi(GibiEntity gibiEntity) {
        return gibiRepository.save(gibiEntity);
    }

    public boolean deleteGibi(Integer id) {

        if (gibiRepository.findById(id).isEmpty())
            return false;

        gibiRepository.deleteById(id);
        return true;
    }

    public GibiEntity updateGibi(int id, GibiEntity gibiEntity) throws GibiInvalidoException {
        if (gibiRepository.findById(id).isEmpty())
            throw new GibiInvalidoException("Desenhista não está no sistema");
        gibiEntity.setGibiId(id);
        return gibiRepository.save(gibiEntity);
    }
}

