package com.editoragibi.editoragibi.Service.BaseObjects;

import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

import java.time.LocalDate;

public abstract class BaseDesenhista {


    protected int desenhistaId;
    protected String nomeDesenhista;
    protected String paisNascimento;
    protected LocalDate dataNascimento;
    protected LocalDate dataFalecimento;
    protected String enderecoDesenhista;
    protected LocalDate dataContratacao;
    protected LocalDate dataDemissao;

    public int getDesenhistaId() {
        return desenhistaId;
    }

    public void setDesenhistaId(int desenhistaId) {
        this.desenhistaId = desenhistaId;
    }

    public String getNomeDesenhista() {
        return nomeDesenhista;
    }

    public abstract void setNomeDesenhista(String nomeDesenhista) throws DesenhistaInvalidoException;

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public abstract void setPaisNascimento(String paisNascimento) throws DesenhistaInvalidoException;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public abstract void setDataNascimento(LocalDate dataNascimento) throws DesenhistaInvalidoException;

    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }

    public abstract void setDataFalecimento(LocalDate dataFalecimento) throws DesenhistaInvalidoException;

    public String getEnderecoDesenhista() {
        return enderecoDesenhista;
    }

    public abstract void setEnderecoDesenhista(String enderecoDesenhista) throws DesenhistaInvalidoException;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public abstract void setDataContratacao(LocalDate dataContratacao) throws DesenhistaInvalidoException;

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public abstract void setDataDemissao(LocalDate dataDemissao) throws DesenhistaInvalidoException;
}
