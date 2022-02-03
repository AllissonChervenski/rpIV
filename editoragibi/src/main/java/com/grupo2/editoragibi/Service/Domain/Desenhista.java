package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;

public class Desenhista {

    private int id;
    private String nomeDesenhista;
    private String paisNascimento;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private String enderecoDesenhista;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public Desenhista() {
    }

    public Desenhista(String nomeDesenhista, String enderecoDesenhista, LocalDate dataContratacao, String paisNascimento, LocalDate dataNascimento) {

        this.nomeDesenhista = nomeDesenhista;
        this.enderecoDesenhista = enderecoDesenhista;
        this.dataContratacao = dataContratacao;
        this.paisNascimento = paisNascimento;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDesenhista() {
        return nomeDesenhista;
    }

    public void setNomeDesenhista(String nomeDesenhista) {
        this.nomeDesenhista = nomeDesenhista;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getEnderecoDesenhista() {
        return enderecoDesenhista;
    }

    public void setEnderecoDesenhista(String enderecoDesenhista) {
        this.enderecoDesenhista = enderecoDesenhista;
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
