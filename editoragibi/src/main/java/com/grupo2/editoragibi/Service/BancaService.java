package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.BancaRequest;
import com.grupo2.editoragibi.Data.BancaRepository;
import com.grupo2.editoragibi.Service.Builders.BancaBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseBancaBuilder;
import com.grupo2.editoragibi.Service.Directors.BancaDirector;
import com.grupo2.editoragibi.Service.Domain.Banca;
import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//TODO tem mais regras de negócio para serem implementadas nessa classe
@Service
public class BancaService {

    private IBaseBancaBuilder bancaBuilder = new BancaBuilder();
    private BancaDirector bancaDirector = new BancaDirector(bancaBuilder);

    @Autowired
    BancaRepository bancaRepository;

    public Banca getBancaById(int id) throws BancaInvalidaException {
        return bancaRepository.getBancaById(id);
    }

    public List<Banca> getBancas() throws BancaInvalidaException {
        return bancaRepository.getBancas();
    }

    public Banca addBanca(BancaRequest bancaRequest) throws BancaInvalidaException {
        Banca banca = (Banca) bancaDirector.buildFromBancaRequest(bancaRequest);
        return bancaRepository.addBanca(banca);
    }

    public void deleteBanca(int id) throws BancaInvalidaException {
        if (!bancaRepository.deleteBanca(id))
            throw new BancaInvalidaException("Essa banca não estava no sistema");
    }

    public Banca updateBanca(int id, BancaRequest bancaRequest) throws BancaInvalidaException {
        Banca banca = (Banca) bancaDirector.buildFromBancaRequest(bancaRequest);
        return bancaRepository.updateBanca(id, banca);
    }
}
