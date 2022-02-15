package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Historia {

    private int historiaId;
    private String tituloHistoria;
    private int totalPaginas;
    private LocalDate dataProducao;
    private Desenhista artefinalizador;
    private Desenhista desenhista;
    private Escritor escritor;
    List<Personagem> personagens = new ArrayList<>();

    public void addPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public Desenhista getArtefinalizador() {
        return artefinalizador;
    }

    public void setArtefinalizador(Desenhista artefinalizador) {
        this.artefinalizador = artefinalizador;
    }

    public Desenhista getDesenhista() {
        return desenhista;
    }

    public void setDesenhista(Desenhista desenhista) {
        this.desenhista = desenhista;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public LocalDate getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(LocalDate dataProducao) {
        this.dataProducao = dataProducao;
    }
}
