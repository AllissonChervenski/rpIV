package com.grupo2.editoragibi.Service.Directors;

import java.util.List;
import java.util.stream.Collectors;

import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Builders.GibiBuilder;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

public class GibiDirector {

    private IBaseGibiBuilder builder;

    public GibiDirector(IBaseGibiBuilder gibiBuilder) {
        this.builder = gibiBuilder;
    }

    public synchronized BaseGibi buildFromGibiRequest(GibiRequest gibiRequest) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        builder.setGibi_id(gibiRequest.getGibi_id());;
        builder.setEncData(gibiRequest.getEncData());
        builder.setInicioData(gibiRequest.getInicioData());
        builder.setTituloGibi(gibiRequest.getTituloGibi());
        builder.setEdicoesGibi(gibiRequest.getEdicoesGibiId());

        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibiEntity(GibiEntity gibiEntity) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        builder.setGibi_id(gibiEntity.getGibi_id());
        builder.setEncData(gibiEntity.getEncData());
        builder.setInicioData(gibiEntity.getInicioData());
        builder.setTituloGibi(gibiEntity.getTituloGibi());
        List<Integer> edicoesGibisIds = gibiEntity.getEdicoesGibis().stream().map(gibi -> {
            return gibi.getEdicaoGibi_id();
        }).collect(Collectors.toList());
        builder.setEdicoesGibi(edicoesGibisIds);
        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibi(Gibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        builder.setGibi_id(gibi.getGibi_id());
        builder.setEncData(gibi.getEncData());
        builder.setInicioData(gibi.getInicioData());
        builder.setTituloGibi(gibi.getTituloGibi());
        List<Integer> edicoesGibisIds = gibi.getEdicoesGibi().stream().map(g -> {
            return g.getEdicaoGibi_id();
        }).collect(Collectors.toList());
        builder.setEdicoesGibi(edicoesGibisIds);

        return builder.getResult();
    }

    public synchronized BaseGibi buildFromGibi(Gibi gibi,  EdicoesGibi edicoesGibi) throws  EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        gibi.getEdicoesGibi().removeIf(p -> p.getEdicaoGibi_id() == edicoesGibi.getEdicaoGibi_id());
        builder.setEdicaoGibi(edicoesGibi);
        return buildFromGibi(gibi);
    }

    public synchronized BaseGibi buildFromGibiEntity(GibiEntity gibi,  EdicoesGibi edicoesGibi) throws  EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        gibi.getEdicoesGibis().removeIf(p -> p.getEdicaoGibi_id() == edicoesGibi.getEdicaoGibi_id());
        builder.setEdicaoGibi(edicoesGibi);
        return buildFromGibiEntity(gibi);
    }
}