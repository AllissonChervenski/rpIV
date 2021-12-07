package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private int personagemId;
    private String nomePersonagem;
    private String historicoPersonagem;
    private String patentePersonagem;
    private LocalDate dataCriacao;
    private List<Escritor> escritores = new ArrayList<>();

    public Personagem(String nomePersonagem, LocalDate dataCriacao) {

        this.nomePersonagem = nomePersonagem;
        this.dataCriacao = dataCriacao;
    }

    public Personagem() {
    }

    public void addEscritor(Escritor escritor) {
        escritores.add(escritor);
    }

    public List<Escritor> getEscritores() {
        return escritores;
    }

    public void setEscritores(List<Escritor> escritores) {
        this.escritores = escritores;
    }

    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
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

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
