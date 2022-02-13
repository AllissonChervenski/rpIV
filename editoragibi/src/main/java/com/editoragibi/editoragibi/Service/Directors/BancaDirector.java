package com.editoragibi.editoragibi.Service.Directors;

import com.editoragibi.editoragibi.Api.Requests.BancaRequest;
import com.editoragibi.editoragibi.Data.Entity.BancaEntity;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import com.editoragibi.editoragibi.Service.Builders.IBaseBancaBuilder;
import com.editoragibi.editoragibi.Service.Domain.Banca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;

public class BancaDirector {

    private IBaseBancaBuilder builder;

    public BancaDirector(IBaseBancaBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseBanca buildFromBancaRequest(BancaRequest bancaRequest) throws BancaInvalidaException {
        builder.setNomeBanca(bancaRequest.getNomeBanca());
        builder.setEnderecoBanca(bancaRequest.getEnderecoBanca());
        builder.setTelefoneBanca(bancaRequest.getTelefoneBanca());

        return builder.getResult();
    }

    public synchronized BaseBanca buildFromBanca(Banca banca) throws BancaInvalidaException {
        builder.setBancaId(banca.getBancaId());
        builder.setNomeBanca(banca.getNomeBanca());
        builder.setEnderecoBanca(banca.getEnderecoBanca());
        builder.setTelefoneBanca(banca.getTelefoneBanca());

        return builder.getResult();
    }

    public synchronized BaseBanca buildFromBancaEntity(BancaEntity bancaEntity) throws BancaInvalidaException {
        builder.setBancaId(bancaEntity.getBancaId());
        builder.setNomeBanca(bancaEntity.getNomeBanca());
        builder.setEnderecoBanca(bancaEntity.getEnderecoBanca());
        builder.setTelefoneBanca(bancaEntity.getTelefoneBanca());

        return builder.getResult();
    }
}
