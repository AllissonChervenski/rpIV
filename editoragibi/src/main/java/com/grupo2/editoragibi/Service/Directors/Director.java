package com.grupo2.editoragibi.Service.Directors;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.IBaseEscritorBuilder;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Director {

    @Autowired
    PersonagemRepository personagemRepository;

    private IBaseEscritorBuilder builder;

    public Director(IBaseEscritorBuilder builder) {
        this.builder = builder;
    }

    public BaseEscritor buildFromEscritorRequest(EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setNomeEscritor(escritorRequest.getNomeEscritor());
        builder.setEnderecoEscritor(escritorRequest.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritorRequest.getTelefoneEscritor());
        builder.setEmailEscritor(escritorRequest.getEmailEscritor());
        builder.setDataContratacao(escritorRequest.getDataContratacao());
        builder.setDataDemissao(escritorRequest.getDataDemissao());
        List<BasePersonagem> personagens = new ArrayList<>();
        for (Integer i : escritorRequest.getPersonagensIds()) {
            personagens.add((BasePersonagem) personagemRepository.getPersonagemById(i));
        }
        builder.setPersonagens(personagens);

        return builder.getResult();
    }

    public BaseEscritor buildFromEscritor(Escritor escritor) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setEscritorId(escritor.getEscritorId());
        builder.setNomeEscritor(escritor.getNomeEscritor());
        builder.setEnderecoEscritor(escritor.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritor.getTelefoneEscritor());
        builder.setEmailEscritor(escritor.getEmailEscritor());
        builder.setDataContratacao(escritor.getDataContratacao());
        builder.setDataDemissao(escritor.getDataDemissao());
        List<Personagem> personagens = escritor.getPersonagens();
        List<BasePersonagem> basePersonagens = new ArrayList<>();
        for (Personagem personagem : personagens) {
            basePersonagens.add((BasePersonagem) personagem);
        }
        builder.setPersonagens(basePersonagens);

        return builder.getResult();
    }

    public BaseEscritor buildFromEscritorEntity(EscritorEntity escritorEntity) throws EscritorInvalidoException, PersonagemInvalidoException {

        builder.setEscritorId(escritorEntity.getEscritorId());
        builder.setNomeEscritor(escritorEntity.getNomeEscritor());
        builder.setEnderecoEscritor(escritorEntity.getEnderecoEscritor());
        builder.setTelefoneEscritor(escritorEntity.getTelefoneEscritor());
        builder.setEmailEscritor(escritorEntity.getEmailEscritor());
        builder.setDataContratacao(escritorEntity.getDataContratacao());
        builder.setDataDemissao(escritorEntity.getDataDemissao());

        List<PersonagemEntity> personagens = escritorEntity.getPersonagens();
        List<BasePersonagem> basePersonagens = new ArrayList<>();
        for (PersonagemEntity personagem : personagens) {
            basePersonagens.add((BasePersonagem) personagem);
        }
        builder.setPersonagens(basePersonagens);

        return builder.getResult();
    }
}
