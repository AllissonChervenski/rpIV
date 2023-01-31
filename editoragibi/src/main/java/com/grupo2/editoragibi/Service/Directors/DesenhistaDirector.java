package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.DesenhistaRequest;
import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseDesenhistaBuilder;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

public class DesenhistaDirector {

    private IBaseDesenhistaBuilder builder;

    public DesenhistaDirector(IBaseDesenhistaBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseDesenhista buildFromDesenhistaRequest(DesenhistaRequest desenhistaRequest) throws DesenhistaInvalidoException {

        builder.setNomeDesenhista(desenhistaRequest.getNomeDesenhista());
        builder.setPaisNascimento(desenhistaRequest.getPaisNascimento());
        builder.setDataNascimento(desenhistaRequest.getDataNascimento());
        builder.setDataFalecimento(desenhistaRequest.getDataFalecimento());
        builder.setEnderecoDesenhista(desenhistaRequest.getEnderecoDesenhista());
        builder.setDataContratacao(desenhistaRequest.getDataContratacao());
        builder.setDataDemissao(desenhistaRequest.getDataDemissao());

        return builder.getResult();
    }

    public synchronized BaseDesenhista buildFromDesenhista(Desenhista desenhista) throws DesenhistaInvalidoException {

        builder.setDesenhistaId(desenhista.getDesenhistaId());
        builder.setNomeDesenhista(desenhista.getNomeDesenhista());
        builder.setPaisNascimento(desenhista.getPaisNascimento());
        builder.setDataNascimento(desenhista.getDataNascimento());
        builder.setDataFalecimento(desenhista.getDataFalecimento());
        builder.setEnderecoDesenhista(desenhista.getEnderecoDesenhista());
        builder.setDataContratacao(desenhista.getDataContratacao());
        builder.setDataDemissao(desenhista.getDataDemissao());

        return builder.getResult();
    }

    public synchronized BaseDesenhista buildFromDesenhistaEntity(DesenhistaEntity desenhistaEntity) throws DesenhistaInvalidoException {
        builder.setDesenhistaId(desenhistaEntity.getDesenhistaId());
        builder.setNomeDesenhista(desenhistaEntity.getNomeDesenhista());
        builder.setPaisNascimento(desenhistaEntity.getPaisNascimento());
        builder.setDataNascimento(desenhistaEntity.getDataNascimento());
        builder.setDataFalecimento(desenhistaEntity.getDataFalecimento());
        builder.setEnderecoDesenhista(desenhistaEntity.getEnderecoDesenhista());
        builder.setDataContratacao(desenhistaEntity.getDataContratacao());
        builder.setDataDemissao(desenhistaEntity.getDataDemissao());

        return builder.getResult();
    }


  
}
