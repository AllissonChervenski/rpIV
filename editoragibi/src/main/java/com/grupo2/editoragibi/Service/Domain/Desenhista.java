package com.grupo2.editoragibi.Service.Domain;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

public class Desenhista {

    private int id;
    private String nomeDesenhista;
    private String enderecoDesenhista;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public Desenhista() {
    }

    public Desenhista(String nomeDesenhista, String enderecoDesenhista) {

        this.nomeDesenhista = nomeDesenhista;
        this.enderecoDesenhista = enderecoDesenhista;
        dataContratacao = LocalDate.now();
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
