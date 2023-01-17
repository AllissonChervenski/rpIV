package com.grupo2.editoragibi.Service.BaseObjects;

import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;

import java.time.LocalDate;

public abstract class BaseEscritor {

    protected int escritorId;
    protected String nomeEscritor;
    protected String enderecoEscritor;
    protected String telefoneEscritor;
    protected String emailEscritor;
    protected LocalDate dataContratacao;
    protected LocalDate dataDemissao;
    protected LocalDate dataNascimentoEs;
    protected LocalDate dataFalecimentoEs;
    protected String paisNascimentoEs;

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

    public LocalDate getDataNascimentoEs() {
        return dataNascimentoEs;
    }

    public void setDataNascimentoEs(LocalDate dataNascimentoEs) {
        this.dataNascimentoEs = dataNascimentoEs;
    }

    public LocalDate getDataFalecimentoEs() {
        return dataFalecimentoEs;
    }

    public void setDataFalecimentoEs(LocalDate dataFalecimentoEs) {
        this.dataFalecimentoEs = dataFalecimentoEs;
    }

    public String getPaisNascimentoEs() {
        return paisNascimentoEs;
    }

    public void setPaisNascimentoEs(String paisNascimentoEs) {
        this.paisNascimentoEs = paisNascimentoEs;
    }
}
