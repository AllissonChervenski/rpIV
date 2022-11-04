package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.EdicoesGibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEdicoesGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;

public class EdicoesGibiDirector {

    private IBaseEdicoesGibiBuilder builder;

    public EdicoesGibiDirector(IBaseEdicoesGibiBuilder builder) {
        this.builder = builder;
    }

    public synchronized EdicoesGibi buildFromEdicoesGibiRequest(EdicoesGibiRequest edicoesGibiRequest) {
        builder.setDataPub(edicoesGibiRequest.getDataPub());
        builder.setEdicaoGibi_id(edicoesGibiRequest.getNroEdicao());
        builder.setNroEdicao(edicoesGibiRequest.getNroEdicao());
        // builder.setNumeroExemplaresImpressas(0);
        // builder.setPublicada(false);
        // builder.setGibi(null);

        return builder.getResult();
    }

    public synchronized EdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibiEntity) {
        builder.setDataPub(edicoesGibiEntity.getDataPub());
        builder.setEdicaoGibi_id(edicoesGibiEntity.getNroEdicao());
        builder.setNroEdicao(edicoesGibiEntity.getNroEdicao());
        // builder.setNumeroExemplaresImpressas(0);
        // builder.setPublicada(false);
        // builder.setGibi(null);

        return builder.getResult();
    }

}
