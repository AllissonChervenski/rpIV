package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

public class GibiDirector {

    private IBaseGibiBuilder builder;

    public GibiDirector(IBaseGibiBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseGibi buildFromGibiRequest(GibiRequest gibiRequest) throws GibiInvalidoException {

        builder.setTituloGibi(gibiRequest.getTituloGibi());
        builder.setInicioData(gibiRequest.getInicioData());
        builder.setEncData(gibiRequest.getEncData());

        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibi(Gibi gibi) throws GibiInvalidoException {

        builder.setGibiId(gibi.getGibiId());
        builder.setTituloGibi(gibi.getTituloGibi());
        builder.setInicioData(gibi.getInicioData());
        builder.setEncData(gibi.getEncData());


        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibiEntity(GibiEntity gibiEntity) throws GibiInvalidoException {
        builder.setGibiId(gibiEntity.getGibiId());
        builder.setTituloGibi(gibiEntity.getTituloGibi());
        builder.setInicioData(gibiEntity.getInicioData());
        builder.setEncData(gibiEntity.getEncData());

        return builder.getResult();
    }
}
