package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.HistoriaRequest;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Builders.IBaseHistoriaBuilder;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

public class HistoriaDirector {

    private IBaseHistoriaBuilder builder;

    public HistoriaDirector(IBaseHistoriaBuilder builder) {
        this.builder = builder;
    }

    public BaseHistoria buildFromHistoriaRequest(HistoriaRequest historiaRequest) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        builder.setTituloHistoria(historiaRequest.getTituloHistoria());
        builder.setTotalPaginas(historiaRequest.getTotalPaginas());
        builder.setDataProducao(historiaRequest.getDataProducao());
        builder.setArtefinalizador(historiaRequest.getArtefinalizadorId());
        builder.setDesenhista(historiaRequest.getDesenhistaId());
        builder.setEscritor(historiaRequest.getEscritorId());

        return builder.getResult();
    }

    public BaseHistoria buildFromHistoria(Historia historia) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        builder.setHistoriaId(historia.getHistoriaId());
        builder.setTituloHistoria(historia.getTituloHistoria());
        builder.setTotalPaginas(historia.getTotalPaginas());
        builder.setDataProducao(historia.getDataProducao());
        builder.setArtefinalizador(historia.getArtefinalizador().getDesenhistaId());
        builder.setDesenhista(historia.getDesenhista().getDesenhistaId());
        builder.setEscritor(historia.getEscritor().getEscritorId());

        return builder.getResult();
    }

    public BaseHistoria buildFromHistoriaEntity(HistoriaEntity historiaEntity) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        builder.setHistoriaId(historiaEntity.getHistoriaId());
        builder.setTituloHistoria(historiaEntity.getTituloHistoria());
        builder.setTotalPaginas(historiaEntity.getTotalPaginas());
        builder.setDataProducao(historiaEntity.getDataProducao());
        builder.setArtefinalizador(historiaEntity.getArtefinalizador().getDesenhistaId());
        builder.setDesenhista(historiaEntity.getDesenhista().getDesenhistaId());
        builder.setEscritor(historiaEntity.getEscritor().getEscritorId());

        return builder.getResult();
    }
}
