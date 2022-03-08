package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Builders.IBaseGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

public class GibiDirector {

    private IBaseGibiBuilder builder;

    public GibiDirector(IBaseGibiBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseGibi buildFromGibi(Gibi gibi) throws GibiInvalidoException {
        builder.setGibiId(gibi.getGibiId());
        builder.setTituloGibi(gibi.getTitulo());
        builder.setInicioDataGibi(gibi.getInicioData());
        builder.setEncDataGibi(gibi.getEncData());

        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibiEntity(GibiEntity gibiEntity) throws GibiInvalidoException {
        builder.setGibiId(gibiEntity.getGibiId());
        builder.setTituloGibi(gibiEntity.getTitulo());
        builder.setInicioDataGibi(gibiEntity.getInicioData());
        builder.setEncDataGibi(gibiEntity.getEncData());

        return builder.getResult();
    }
}
