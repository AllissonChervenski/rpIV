package com.grupo2.editoragibi.Service.ServiceObjects;

import com.grupo2.editoragibi.Api.Requests.BancaRequest;
import com.grupo2.editoragibi.Data.Entity.BancaEntity;
import com.grupo2.editoragibi.Data.Repositories.BancaRepository;
import com.grupo2.editoragibi.Service.Directors.BancaDirector;
import com.grupo2.editoragibi.Service.Domain.Banca;
import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;
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
