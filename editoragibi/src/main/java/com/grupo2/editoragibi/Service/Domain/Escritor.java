package com.grupo2.editoragibi.Service.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.HistoriaRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Escritor extends BaseEscritor {

    @JsonBackReference
    private List<Personagem> personagens = new ArrayList<>();
    private PersonagemRepository personagemRepository;

    public Escritor(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    @Override
    public void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException {
        if (nomeEscritor == null || !Pattern.matches("^[a-zA-Z\\s]([a-zA-Z])[a-zA-Z\\s]{1,20}$", nomeEscritor))
            throw new EscritorInvalidoException("Nome inválido");
        this.nomeEscritor = nomeEscritor;
    }

    public void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException {
        if (enderecoEscritor == null || !Pattern.matches("^[\\w\\s-]{1,25}$", enderecoEscritor))
            throw new EscritorInvalidoException("Endereço do escritor inválido");
        this.enderecoEscritor = enderecoEscritor;
    }

    public void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException {
        if (telefoneEscritor == null || !Pattern.matches("^\\d{11}$", telefoneEscritor))
            throw new EscritorInvalidoException("Numero de telefone inválido");
        this.telefoneEscritor = telefoneEscritor;
    }

    public void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException {
        if (emailEscritor == null || !Pattern.matches("^[_a-zA-Z0-9-\\+]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$", emailEscritor))
            throw new EscritorInvalidoException("Email inválido");
        this.emailEscritor = emailEscritor;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    //TODO
    public Personagem criaPersonagem(int personagemId) throws PersonagemInvalidoException, EscritorInvalidoException {

        for (Personagem personagem : personagens)
            if (personagem.getPersonagemId() == personagemId)
                throw new IllegalArgumentException("O escritor já criou esse personagem");

        Personagem personagem = personagemRepository.getPersonagemById(personagemId);
        personagens.add(personagem);
        personagem.addEscritor(this);

        return personagem;
    }
}
