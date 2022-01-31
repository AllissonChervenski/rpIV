package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.BancaEntity;
import com.grupo2.editoragibi.Service.Builders.BancaBuilder;
import com.grupo2.editoragibi.Service.Builders.BancaEntityBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseBancaBuilder;
import com.grupo2.editoragibi.Service.Directors.BancaDirector;
import com.grupo2.editoragibi.Service.Domain.Banca;
import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BancaRepository {

    private IBaseBancaBuilder bancaBuilder = new BancaBuilder();
    private IBaseBancaBuilder bancaEntityBuilder = new BancaEntityBuilder();
    private BancaDirector bancaDirector = new BancaDirector(bancaBuilder);
    private BancaDirector bancaEntityDirector = new BancaDirector(bancaEntityBuilder);

    @Autowired
    IBancaRepository bancaRepository;

    public Banca getBancaById(int id) throws BancaInvalidaException {
        Optional<BancaEntity> bancaEntity = bancaRepository.findById(id);
        if (bancaEntity.isEmpty())
            throw new BancaInvalidaException("Essa banca não está no sistema");
        return (Banca) bancaDirector.buildFromBancaEntity(bancaEntity.get());
    }

    public List<Banca> getBancas() throws BancaInvalidaException {
        List<BancaEntity> bancasEntity = bancaRepository.findAll();
        List<Banca> bancas = new ArrayList<>();
        for (BancaEntity banca : bancasEntity) {
            bancas.add((Banca) bancaDirector.buildFromBancaEntity(banca));
        }
        return bancas;
    }

    public Banca addBanca(Banca banca) throws BancaInvalidaException {
        BancaEntity bancaEntity = (BancaEntity) bancaEntityDirector.buildFromBanca(banca);
        BancaEntity bancaToReturn = bancaRepository.save(bancaEntity);
        return (Banca) bancaDirector.buildFromBancaEntity(bancaToReturn);
    }

    public boolean deleteBanca(int id) {
        if (bancaRepository.findById(id).isEmpty())
            return false;
        bancaRepository.deleteById(id);
        return true;
    }

    public Banca updateBanca(int id, Banca banca) throws BancaInvalidaException {
        if (bancaRepository.findById(id).isEmpty())
            throw new BancaInvalidaException("A banca não está no sistma");
        banca.setBancaId(id);
        BancaEntity bancaEntity = (BancaEntity) bancaEntityDirector.buildFromBanca(banca);
        BancaEntity bancaToReturn = bancaRepository.save(bancaEntity);
        return (Banca) bancaDirector.buildFromBancaEntity(bancaToReturn);
    }
}
