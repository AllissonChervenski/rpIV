package com.editoragibi.editoragibi.Service;

import com.editoragibi.editoragibi.Api.Requests.BancaRequest;
import com.editoragibi.editoragibi.Data.BancaRepository;
import com.editoragibi.editoragibi.Data.Entity.BancaEntity;
import com.editoragibi.editoragibi.Service.Directors.BancaDirector;
import com.editoragibi.editoragibi.Service.Domain.Banca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//TODO tem mais regras de negócio para serem implementadas nessa classe, relacionadas principalmente com a exclusão e associações das bancas
@Service
public class BancaService {

    @Autowired
    BancaDirector bancaDirector;

    @Autowired
    BancaDirector bancaEntityDirector;

    @Autowired
    BancaRepository bancaRepository;

    public Banca getBancaById(int id) throws BancaInvalidaException {
        return (Banca) bancaDirector.buildFromBancaEntity(bancaRepository.getBancaById(id));
    }

    public List<Banca> getBancas() throws BancaInvalidaException {
        List<BancaEntity> bancasEntities = bancaRepository.getBancas();
        List<Banca> bancas = new ArrayList<>();
        for (BancaEntity banca : bancasEntities)
            bancas.add((Banca) bancaDirector.buildFromBancaEntity(banca));
        return bancas;
    }

    public Banca addBanca(BancaRequest bancaRequest) throws BancaInvalidaException {
        Banca banca = (Banca) bancaDirector.buildFromBancaRequest(bancaRequest);
        BancaEntity bancaEntity = (BancaEntity) bancaEntityDirector.buildFromBanca(banca);
        return (Banca) bancaDirector.buildFromBancaEntity(bancaRepository.addBanca(bancaEntity));
    }

    public void deleteBanca(int id) throws BancaInvalidaException {
        if (!bancaRepository.deleteBanca(id))
            throw new BancaInvalidaException("Essa banca não estava no sistema");
    }

    public Banca updateBanca(int id, BancaRequest bancaRequest) throws BancaInvalidaException {
        Banca banca = (Banca) bancaDirector.buildFromBancaRequest(bancaRequest);
        BancaEntity bancaEntity = (BancaEntity) bancaEntityDirector.buildFromBanca(banca);
        return (Banca) bancaDirector.buildFromBancaEntity(bancaRepository.updateBanca(id, bancaEntity));
    }
}
