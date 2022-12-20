package com.grupo2.editoragibi.Service.Directors;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.grupo2.editoragibi.Api.Requests.EdicoesGibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEdicoesGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

public class EdicoesGibiDirector {

    private IBaseEdicoesGibiBuilder builder;

    public EdicoesGibiDirector(IBaseEdicoesGibiBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiRequest(EdicoesGibiRequest edicoesGibiRequest) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException{
      
            builder.setDataPub(edicoesGibiRequest.getDataPub());
            builder.setEdicaoGibiId(edicoesGibiRequest.getEdicaoGibi_id());
            builder.setNroEdicao(edicoesGibiRequest.getNroEdicao());
            builder.setNumeroExemplaresImpressas(edicoesGibiRequest.getNumeroExemplaresImpressas());
            builder.setPublicada(edicoesGibiRequest.isPublicada());
            builder.setGibi(edicoesGibiRequest.getGibi());
            builder.setHistoria(edicoesGibiRequest.getHistoria());
            builder.setPersonagens(edicoesGibiRequest.getPersonagensId());
            builder.setEscritores(edicoesGibiRequest.getEscritorId());
      
        return builder.getResult();
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibiEntity) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        builder.setDataPub(edicoesGibiEntity.getDataPub());
        builder.setEdicaoGibiId(edicoesGibiEntity.getEdicaoGibi_id());
        builder.setNroEdicao(edicoesGibiEntity.getNroEdicao());
        builder.setNumeroExemplaresImpressas(edicoesGibiEntity.getNumeroExemplaresImpressas());
        builder.setPublicada(edicoesGibiEntity.isPublicada());
        builder.setGibi(edicoesGibiEntity.getGibi());
        List<Integer> desenhistasId = edicoesGibiEntity.getDesenhista().stream().map(desenhista -> { 
            return desenhista.getDesenhistaId();
        }).collect(Collectors.toList());
        builder.setDesenhistas(desenhistasId);
        List<Integer> personagensId = edicoesGibiEntity.getPersonagem().stream().map(personagem -> { 
            return personagem.getPersonagemId();
        }).collect(Collectors.toList());
        builder.setPersonagens(personagensId);
        List<Integer> escritores = edicoesGibiEntity.getEscritor().stream().map(escritor -> { 
            return escritor.getEscritorId();
        }).collect(Collectors.toList());
        builder.setEscritores(escritores);

        builder.setHistoria(edicoesGibiEntity.getHistoria());

        return builder.getResult();
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{

        builder.setDataPub(edicoesGibi.getDataPub());
        builder.setEdicaoGibiId(edicoesGibi.getEdicaoGibi_id());
        builder.setNroEdicao(edicoesGibi.getNroEdicao());
        builder.setNumeroExemplaresImpressas(edicoesGibi.getNumeroExemplaresImpressas());
        builder.setPublicada(edicoesGibi.isPublicada());
        builder.setGibi(edicoesGibi.getGibi());
        List<Integer> desenhistasId = edicoesGibi.getDesenhista().stream().map(desenhista -> { 
            return desenhista.getDesenhistaId();
        }).collect(Collectors.toList());
        builder.setDesenhistas(desenhistasId);
        List<Integer> personagensId = edicoesGibi.getPersonagem().stream().map(personagem -> { 
            return personagem.getPersonagemId();
        }).collect(Collectors.toList());
        builder.setPersonagens(personagensId);
        List<Integer> escritores = edicoesGibi.getEscritor().stream().map(escritor -> { 
            return escritor.getEscritorId();
        }).collect(Collectors.toList());
        builder.setEscritores(escritores);

        builder.setHistoria(edicoesGibi.getHistoria());

        return builder.getResult();
    }

    public  synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi, BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        builder.setGibi(gibi);
        return buildFromEdicoesGibi(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibi, BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        builder.setGibi(gibi);
        return buildFromEdicoesGibiEntity(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi, BaseHistoria historia) throws GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        builder.setHistoria(historia);
        return buildFromEdicoesGibi(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibi, BaseHistoria historia) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibi.getHistoria();
        builder.setHistoria(historia);
        return buildFromEdicoesGibiEntity(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi, BasePersonagem personagem) throws  EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibi.getPersonagem().removeIf(p -> p.getPersonagemId() == personagem.getPersonagemId());
        builder.setPersonagem(personagem);
        return buildFromEdicoesGibi(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibiEntity, BasePersonagem personagem) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibiEntity.getPersonagem().removeIf(p -> p.getPersonagemId() == personagem.getPersonagemId());
        builder.setPersonagem(personagem);
        return buildFromEdicoesGibiEntity(edicoesGibiEntity);
    }
//desenhistas

    public synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi, BaseDesenhista desenhista) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibi.getDesenhista().removeIf(p -> p.getDesenhistaId() == desenhista.getDesenhistaId());
        builder.setDesenhista(desenhista);
        return buildFromEdicoesGibi(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibiEntity, BaseDesenhista desenhista) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibiEntity.getDesenhista().removeIf(p -> p.getDesenhistaId() == desenhista.getDesenhistaId());
        builder.setDesenhista(desenhista);
        return buildFromEdicoesGibiEntity(edicoesGibiEntity);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibi(EdicoesGibi edicoesGibi, BaseEscritor escritor) throws  EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibi.getEscritor().removeIf(p -> p.getEscritorId() == escritor.getEscritorId());
        builder.setEscritor(escritor);
        return buildFromEdicoesGibi(edicoesGibi);
    }

    public synchronized BaseEdicoesGibi buildFromEdicoesGibiEntity(EdicoesGibiEntity edicoesGibiEntity, BaseEscritor escritor) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException{
        edicoesGibiEntity.getEscritor().removeIf(p -> p.getEscritorId() == escritor.getEscritorId());
        builder.setEscritor(escritor);
        return buildFromEdicoesGibiEntity(edicoesGibiEntity);
    }


}
