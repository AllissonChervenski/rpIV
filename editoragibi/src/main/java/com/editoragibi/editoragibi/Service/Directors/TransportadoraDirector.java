package com.editoragibi.editoragibi.Service.Directors;

import com.editoragibi.editoragibi.Api.Requests.TransportadoraRequest;
import com.editoragibi.editoragibi.Data.Entity.TransportadoraEntity;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.editoragibi.editoragibi.Service.Builders.IBaseTransportadoraBuilder;
import com.editoragibi.editoragibi.Service.Domain.Transportadora;
import com.editoragibi.editoragibi.Service.Exceptions.TransportadoraInvalidaException;

public class TransportadoraDirector {

    private IBaseTransportadoraBuilder builder;

    public TransportadoraDirector(IBaseTransportadoraBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseTransportadora buildFromTransportadoraRequest(TransportadoraRequest transportadoraRequest) throws TransportadoraInvalidaException {
        builder.setNomeTransportadora(transportadoraRequest.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadoraRequest.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadoraRequest.getTelefoneTransportadora());

        return builder.getResult();
    }

    public synchronized BaseTransportadora buildFromTransportadora(Transportadora transportadora) throws TransportadoraInvalidaException {
        builder.setTransportadoraId(transportadora.getTransportadoraId());
        builder.setNomeTransportadora(transportadora.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadora.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadora.getTelefoneTransportadora());

        return builder.getResult();
    }

    public synchronized BaseTransportadora buildFromTransportadoraEntity(TransportadoraEntity transportadoraEntity) throws TransportadoraInvalidaException {
        builder.setTransportadoraId(transportadoraEntity.getTransportadoraId());
        builder.setNomeTransportadora(transportadoraEntity.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadoraEntity.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadoraEntity.getTelefoneTransportadora());

        return builder.getResult();
    }
}
