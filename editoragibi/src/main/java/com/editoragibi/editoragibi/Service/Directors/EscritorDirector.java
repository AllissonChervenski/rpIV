package com.editoragibi.editoragibi.Service.Directors;

import com.editoragibi.editoragibi.Api.Requests.EscritorRequest;
import com.editoragibi.editoragibi.Data.Entity.EscritorEntity;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseEscritor;
import com.editoragibi.editoragibi.Service.BaseObjects.BasePersonagem;
import com.editoragibi.editoragibi.Service.Builders.IBaseEscritorBuilder;
import com.editoragibi.editoragibi.Service.Domain.Escritor;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.util.List;
import java.util.stream.Collectors;

public class EscritorDirector {

    private IBaseEscritorBuilder builder;

    public EscritorDirector(IBaseEscritorBuilder builder) {
        this.builder = builder;
    }

    public synchronized BaseEscritor buildFromEscritorRequest(EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setNomeEscritor(escritorRequest.getNomeEscritor());
        builder.setEnderecoEscritor(escritorRequest.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritorRequest.getTelefoneEscritor());
        builder.setEmailEscritor(escritorRequest.getEmailEscritor());
        builder.setDataContratacao(escritorRequest.getDataContratacao());
        builder.setDataDemissao(escritorRequest.getDataDemissao());
        builder.setPersonagens(escritorRequest.getPersonagensIds());

        return builder.getResult();
    }

    public synchronized BaseEscritor buildFromEscritor(Escritor escritor, BasePersonagem personagem) throws PersonagemInvalidoException, EscritorInvalidoException {
        escritor.getPersonagens().removeIf(p -> p.getPersonagemId() == personagem.getPersonagemId());
        builder.setPersonagem(personagem);
        return buildFromEscritor(escritor);
    }

    public synchronized BaseEscritor buildFromEscritor(Escritor escritor) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setEscritorId(escritor.getEscritorId());
        builder.setNomeEscritor(escritor.getNomeEscritor());
        builder.setEnderecoEscritor(escritor.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritor.getTelefoneEscritor());
        builder.setEmailEscritor(escritor.getEmailEscritor());
        builder.setDataContratacao(escritor.getDataContratacao());
        builder.setDataDemissao(escritor.getDataDemissao());
        List<Integer> personagensIds = escritor.getPersonagens().stream().map(personagem -> {
            return personagem.getPersonagemId();
        }).collect(Collectors.toList());
        builder.setPersonagens(personagensIds);

        return builder.getResult();
    }

    public synchronized BaseEscritor buildFromEscritorEntity(EscritorEntity escritorEntity, BasePersonagem personagem) throws PersonagemInvalidoException,
            EscritorInvalidoException {
        escritorEntity.getPersonagens().removeIf(p -> p.getPersonagemId() == personagem.getPersonagemId());
        builder.setPersonagem(personagem);
        return buildFromEscritorEntity(escritorEntity);
    }

    public synchronized BaseEscritor buildFromEscritorEntity(EscritorEntity escritorEntity) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setEscritorId(escritorEntity.getEscritorId());
        builder.setNomeEscritor(escritorEntity.getNomeEscritor());
        builder.setEnderecoEscritor(escritorEntity.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritorEntity.getTelefoneEscritor());
        builder.setEmailEscritor(escritorEntity.getEmailEscritor());
        builder.setDataContratacao(escritorEntity.getDataContratacao());
        builder.setDataDemissao(escritorEntity.getDataDemissao());
        List<Integer> personagensIds = escritorEntity.getPersonagens().stream().map(personagem -> {
            return personagem.getPersonagemId();
        }).collect(Collectors.toList());
        builder.setPersonagens(personagensIds);

        return builder.getResult();
    }
}
