package com.editoragibi.editoragibi.Service.BaseObjects;

import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;

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

    public abstract void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException;

    public String getHistoricoPersonagem() {
        return historicoPersonagem;
    }

    public abstract void setHistoricoPersonagem(String historicoPersonagem);

    public String getPatentePersonagem() {
        return patentePersonagem;
    }

    public abstract void setPatentePersonagem(String patentePersonagem);

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public abstract void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException;
}
