package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.TransportadoraRequest;
import com.grupo2.editoragibi.Data.Entity.TransportadoraEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.grupo2.editoragibi.Service.Builders.IBaseTransportadoraBuilder;
import com.grupo2.editoragibi.Service.Domain.Transportadora;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;

public class TransportadoraDirector {

    private IBaseTransportadoraBuilder builder;

    public TransportadoraDirector(IBaseTransportadoraBuilder builder) {
        this.builder = builder;
    }

    public BaseTransportadora buildFromTransportadoraRequest(TransportadoraRequest transportadoraRequest) throws TransportadoraInvalidaException {
        builder.setNomeTransportadora(transportadoraRequest.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadoraRequest.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadoraRequest.getTelefoneTransportadora());

        return builder.getResult();
    }

    public BaseTransportadora buildFromTransportadora(Transportadora transportadora) throws TransportadoraInvalidaException {
        builder.setTransportadoraId(transportadora.getTransportadoraId());
        builder.setNomeTransportadora(transportadora.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadora.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadora.getTelefoneTransportadora());

        return builder.getResult();
    }

    public BaseTransportadora buildFromTransportadoraEntity(TransportadoraEntity transportadoraEntity) throws TransportadoraInvalidaException {
        builder.setTransportadoraId(transportadoraEntity.getTransportadoraId());
        builder.setNomeTransportadora(transportadoraEntity.getNomeTransportadora());
        builder.setEnderecoTransportadora(transportadoraEntity.getEnderecoTransportadora());
        builder.setTelefoneTransportadora(transportadoraEntity.getTelefoneTransportadora());

        return builder.getResult();
    }
}
