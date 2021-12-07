package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Escritor {

    private int escritorId;
    private String nomeEscritor;
    private String enderecoEscritor;
    private String telefoneEscritor;
    private String emailEscritor;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public Escritor(String nomeEscritor, String enderecoEscritor, String telefoneEscritor, String emailEscritor, LocalDate dataContratacao) {

        this.nomeEscritor = nomeEscritor;
        this.enderecoEscritor = enderecoEscritor;
        this.telefoneEscritor = telefoneEscritor;
        this.emailEscritor = emailEscritor;
        this.dataContratacao = dataContratacao;
    }

    public Escritor() {
    }

    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    public String getNomeEscritor() {
        return nomeEscritor;
    }

    public void setNomeEscritor(String nomeEscritor) {
        this.nomeEscritor = nomeEscritor;
    }

    public String getEnderecoEscritor() {
        return enderecoEscritor;
    }

    public void setEnderecoEscritor(String enderecoEscritor) {
        this.enderecoEscritor = enderecoEscritor;
    }

    public String getTelefoneEscritor() {
        return telefoneEscritor;
    }

    public void setTelefoneEscritor(String telefoneEscritor) {
        this.telefoneEscritor = telefoneEscritor;
    }

    public String getEmailEscritor() {
        return emailEscritor;
    }

    public void setEmailEscritor(String emailEscritor) {
        this.emailEscritor = emailEscritor;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
}
