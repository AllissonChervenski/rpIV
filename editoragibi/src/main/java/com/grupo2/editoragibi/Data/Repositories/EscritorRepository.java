package com.grupo2.editoragibi.Data.Repositories;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEscritorRepository;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EscritorRepository {

    @Autowired
    IEscritorRepository escritorRepository;

    public EscritorEntity getEscritorById(int id) throws EscritorInvalidoException, PersonagemInvalidoException {
        Optional<EscritorEntity> escritorEntity = escritorRepository.findById(id);
        if (escritorEntity.isEmpty())
            throw new EscritorInvalidoException("Escritor não está no sistema");
        return escritorEntity.get();
    }

    public List<EscritorEntity> getEscritores() throws PersonagemInvalidoException, EscritorInvalidoException {
        return escritorRepository.findAll();
    }

    public EscritorEntity addEscritor(EscritorEntity escritorEntity) throws EscritorInvalidoException, PersonagemInvalidoException {
        return escritorRepository.save(escritorEntity);
    }

    public boolean deleteEscritor(int id) {

        if (escritorRepository.findById(id).isEmpty())
            return false;

        escritorRepository.deleteById(id);
        return true;
    }

    public EscritorEntity updateEscritor(int id, EscritorEntity escritorEntity) throws EscritorInvalidoException, PersonagemInvalidoException {
        if (escritorRepository.findById(id).isEmpty())
            throw new EscritorInvalidoException("Escritor não está no sistema");
        escritorEntity.setEscritorId(id);
        return escritorRepository.save(escritorEntity);
    }
}
