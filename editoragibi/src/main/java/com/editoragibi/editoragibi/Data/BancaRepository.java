package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.BancaEntity;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BancaRepository {

    @Autowired
    IBancaRepository bancaRepository;

    public BancaEntity getBancaById(int id) throws BancaInvalidaException {
        Optional<BancaEntity> bancaEntity = bancaRepository.findById(id);
        if (bancaEntity.isEmpty())
            throw new BancaInvalidaException("Essa banca não está no sistema");
        return bancaEntity.get();
    }

    public List<BancaEntity> getBancas() {
        return bancaRepository.findAll();
    }

    public BancaEntity addBanca(BancaEntity banca) throws BancaInvalidaException {
        return bancaRepository.save(banca);
    }

    public boolean deleteBanca(int id) {
        if (bancaRepository.findById(id).isEmpty())
            return false;
        bancaRepository.deleteById(id);
        return true;
    }

    public BancaEntity updateBanca(int id, BancaEntity banca) throws BancaInvalidaException {
        if (bancaRepository.findById(id).isEmpty())
            throw new BancaInvalidaException("A banca não está no sistema");
        banca.setBancaId(id);
        return bancaRepository.save(banca);
    }
}
