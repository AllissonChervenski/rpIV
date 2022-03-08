package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GibiRepository {

    @Autowired
    IGibiRepository gibiRepository;

    public GibiEntity getGibiById(int id) throws GibiInvalidoException {
        Optional<GibiEntity> gibi = gibiRepository.findById(id);
        if (gibi.isEmpty())
            throw new GibiInvalidoException("O gibi não está no sistema");
        return gibi.get();
    }

    public List<GibiEntity> getGibis() {
        return gibiRepository.findAll();
    }

    public GibiEntity addGibi(GibiEntity gibi) {
        return gibiRepository.save(gibi);
    }

    public boolean deleteGibi(int id) {
        if (gibiRepository.findById(id).isEmpty())
            return false;
        gibiRepository.deleteById(id);
        return true;
    }

    public GibiEntity updateGibi(int id, GibiEntity gibi) throws GibiInvalidoException {
        if (gibiRepository.findById(id).isEmpty())
            throw new GibiInvalidoException("O gibi não está no sistema");
        gibi.setGibiId(id);
        return gibiRepository.save(gibi);
    }
}
