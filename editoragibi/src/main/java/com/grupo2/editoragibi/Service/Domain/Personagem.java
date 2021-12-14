package com.grupo2.editoragibi.Service.Domain;

<<<<<<< HEAD
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;

=======
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
import com.fasterxml.jackson.annotation.JsonManagedReference;

>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private int personagemId;
    private String nomePersonagem;
    private String historicoPersonagem;
    private String patentePersonagem;
    private LocalDate dataCriacao;
<<<<<<< HEAD
<<<<<<< HEAD
    @JsonManagedReference
    private List<Escritor> escritores = new ArrayList<>();

=======
    private List<Escritor> escritores = new ArrayList<>();

    public Personagem(String nomePersonagem, LocalDate dataCriacao) {

        this.nomePersonagem = nomePersonagem;
        this.dataCriacao = dataCriacao;
    }

    public Personagem() {
    }

>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    @JsonManagedReference
    private List<Escritor> escritores = new ArrayList<>();

>>>>>>> 0e6e52f (tratamento de exceções apropriado)
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
