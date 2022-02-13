package com.editoragibi.editoragibi.Service.Directors;

import com.editoragibi.editoragibi.Api.Requests.PersonagemRequest;
import com.editoragibi.editoragibi.Data.Entity.PersonagemEntity;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseEscritor;
import com.editoragibi.editoragibi.Service.BaseObjects.BasePersonagem;
import com.editoragibi.editoragibi.Service.Builders.IBasePersonagemBuilder;
import com.editoragibi.editoragibi.Service.Domain.Personagem;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.util.List;
import java.util.stream.Collectors;

public class PersonagemDirector {

    private IBasePersonagemBuilder builder;

    public PersonagemDirector(IBasePersonagemBuilder builder) {
        this.builder = builder;
    }

    public synchronized BasePersonagem buildFromPersonagemRequest(PersonagemRequest personagemRequest) throws PersonagemInvalidoException, EscritorInvalidoException {

        builder.setNomePersonagem(personagemRequest.getNomePersonagem());
        builder.setHistoriaPersonagem(personagemRequest.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagemRequest.getPatentePersonagem());
        builder.setDataCriacao(personagemRequest.getDataCriacao());
        builder.setEscritores(personagemRequest.getEscritoresIds());

        return builder.getResult();
    }

    public  synchronized BasePersonagem buildFromPersonagem(Personagem personagem, BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException {
        personagem.getEscritores().removeIf(e -> e.getEscritorId() == escritor.getEscritorId());
        builder.setEscritor(escritor);
        return buildFromPersonagem(personagem);
    }

    public synchronized BasePersonagem buildFromPersonagem(Personagem personagem) throws PersonagemInvalidoException, EscritorInvalidoException {

        builder.setPersonagemId(personagem.getPersonagemId());
        builder.setNomePersonagem(personagem.getNomePersonagem());
        builder.setHistoriaPersonagem(personagem.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagem.getPatentePersonagem());
        builder.setDataCriacao(personagem.getDataCriacao());
        List<Integer> escritoresIds = personagem.getEscritores().stream().map(escritor -> {
            return escritor.getEscritorId();
        }).collect(Collectors.toList());
        builder.setEscritores(escritoresIds);

        return builder.getResult();
    }

    public synchronized BasePersonagem buildFromPersonagemEntity(PersonagemEntity personagemEntity, BaseEscritor escritor) throws PersonagemInvalidoException,
            EscritorInvalidoException {
        personagemEntity.getEscritores().removeIf(e -> e.getEscritorId() == escritor.getEscritorId());
        builder.setEscritor(escritor);
        return buildFromPersonagemEntity(personagemEntity);
    }

    public synchronized BasePersonagem buildFromPersonagemEntity(PersonagemEntity personagemEntity) throws PersonagemInvalidoException, EscritorInvalidoException {

        builder.setPersonagemId(personagemEntity.getPersonagemId());
        builder.setNomePersonagem(personagemEntity.getNomePersonagem());
        builder.setHistoriaPersonagem(personagemEntity.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagemEntity.getPatentePersonagem());
        builder.setDataCriacao(personagemEntity.getDataCriacao());
        List<Integer> escritoresIds = personagemEntity.getEscritores().stream().map(escritor -> {
            return escritor.getEscritorId();
        }).collect(Collectors.toList());
        builder.setEscritores(escritoresIds);

        return builder.getResult();
    }
}
