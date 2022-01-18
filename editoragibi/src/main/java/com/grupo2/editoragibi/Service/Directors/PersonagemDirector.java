package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.IBasePersonagemBuilder;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonagemDirector {

    @Autowired
    EscritorRepository escritorRepository;

    private IBasePersonagemBuilder builder;

    public PersonagemDirector(IBasePersonagemBuilder builder) {
        this.builder = builder;
    }

    public BasePersonagem buildFromPersonagemRequest(PersonagemRequest personagemRequest) throws PersonagemInvalidoException, EscritorInvalidoException {

        builder.setNomePersonagem(personagemRequest.getNomePersonagem());
        builder.setHistoriaPersonagem(personagemRequest.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagemRequest.getPatentePersonagem());
        builder.setDataCriacao(personagemRequest.getDataCriacao());
        List<BaseEscritor> escritores = new ArrayList<>();
        for (Integer i : personagemRequest.getEscritoresIds()) {
            escritores.add((BaseEscritor) escritorRepository.getEscritorById(i));
        }
        builder.setEscritores(escritores);

        return builder.getResult();
    }

    public BasePersonagem buildFromPersonagem(Personagem personagem) throws PersonagemInvalidoException {

        builder.setPersonagemId(personagem.getPersonagemId());
        builder.setNomePersonagem(personagem.getNomePersonagem());
        builder.setHistoriaPersonagem(personagem.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagem.getPatentePersonagem());
        builder.setDataCriacao(personagem.getDataCriacao());
        List<BaseEscritor> escritores = new ArrayList<>();
        for (Escritor escritor : personagem.getEscritores()) {
            escritores.add((BaseEscritor) escritor);
        }
        builder.setEscritores(escritores);

        return builder.getResult();
    }

    public BasePersonagem buildFromPersonagemEntity(PersonagemEntity personagemEntity) throws PersonagemInvalidoException {

        builder.setPersonagemId(personagemEntity.getPersonagemId());
        builder.setNomePersonagem(personagemEntity.getNomePersonagem());
        builder.setHistoriaPersonagem(personagemEntity.getHistoricoPersonagem());
        builder.setPatentePersonagem(personagemEntity.getPatentePersonagem());
        builder.setDataCriacao(personagemEntity.getDataCriacao());
        List<BaseEscritor> escritores = new ArrayList<>();
        for (EscritorEntity escritor : personagemEntity.getEscritores()) {
            escritores.add((BaseEscritor) escritor);
        }
        builder.setEscritores(escritores);

        return builder.getResult();
    }
}
