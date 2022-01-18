package com.grupo2.editoragibi.Service.BaseObjects;

import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;

public abstract class BasePersonagem {

    protected int personagemId;
    protected String nomePersonagem;
    protected String historicoPersonagem;
    protected String patentePersonagem;
    protected LocalDate dataCriacao;

    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
        this.nomePersonagem = nomePersonagem;
    }

    public String getHistoricoPersonagem() {
        return historicoPersonagem;
    }

    public void setHistoricoPersonagem(String historicoPersonagem) {
        this.historicoPersonagem = historicoPersonagem;
    }

    public String getPatentePersonagem() {
        return patentePersonagem;
    }

    public void setPatentePersonagem(String patentePersonagem) {
        this.patentePersonagem = patentePersonagem;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
        this.dataCriacao = dataCriacao;
    }
}
