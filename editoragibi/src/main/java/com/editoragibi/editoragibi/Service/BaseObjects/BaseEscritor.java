package com.editoragibi.editoragibi.Service.BaseObjects;

import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;

import java.time.LocalDate;

public abstract class BaseEscritor {

    protected int escritorId;
    protected String nomeEscritor;
    protected String enderecoEscritor;
    protected String telefoneEscritor;
    protected String emailEscritor;
    protected LocalDate dataContratacao;
    protected LocalDate dataDemissao;

    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    public String getNomeEscritor() {
        return nomeEscritor;
    }

    public abstract void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException;

    public String getEnderecoEscritor() {
        return enderecoEscritor;
    }

    public abstract void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException;

    public String getTelefoneEscritor() {
        return telefoneEscritor;
    }

    public abstract void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException;

    public String getEmailEscritor() {
        return emailEscritor;
    }

    public abstract void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public abstract void setDataContratacao(LocalDate dataContratacao) throws EscritorInvalidoException;

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public abstract void setDataDemissao(LocalDate dataDemissao) throws EscritorInvalidoException;
}
