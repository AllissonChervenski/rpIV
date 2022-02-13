package com.editoragibi.editoragibi.Service.Directors;

import com.editoragibi.editoragibi.Api.Requests.HistoriaRequest;
import com.editoragibi.editoragibi.Data.Entity.HistoriaEntity;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseHistoria;
import com.editoragibi.editoragibi.Service.Builders.IBaseHistoriaBuilder;
import com.editoragibi.editoragibi.Service.Domain.Historia;
import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;

public class HistoriaDirector {

    private IBaseHistoriaBuilder builder;

    public HistoriaDirector(IBaseHistoriaBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseHistoria buildFromHistoriaRequest(HistoriaRequest historiaRequest) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        builder.setTituloHistoria(historiaRequest.getTituloHistoria());
        builder.setTotalPaginas(historiaRequest.getTotalPaginas());
        builder.setDataProducao(historiaRequest.getDataProducao());
        builder.setArtefinalizador(historiaRequest.getArtefinalizadorId());
        builder.setDesenhista(historiaRequest.getDesenhistaId());
        builder.setEscritor(historiaRequest.getEscritorId());

        return builder.getResult();
    }

    public synchronized BaseHistoria buildFromHistoria(Historia historia) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        builder.setHistoriaId(historia.getHistoriaId());
        builder.setTituloHistoria(historia.getTituloHistoria());
        builder.setTotalPaginas(historia.getTotalPaginas());
        builder.setDataProducao(historia.getDataProducao());
        builder.setArtefinalizador(historia.getArtefinalizador().getDesenhistaId());
        builder.setDesenhista(historia.getDesenhista().getDesenhistaId());
        builder.setEscritor(historia.getEscritor().getEscritorId());

        return builder.getResult();
    }

    public synchronized BaseHistoria buildFromHistoriaEntity(HistoriaEntity historiaEntity) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

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
