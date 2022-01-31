package com.editoragibi.editoragibi.gibi;

import com.editoragibi.editoragibi.edicoes.EdicoesGibi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Gibi {
    public Gibi(Long gibi_id, String titulo, LocalDate inicioData, LocalDate encData, int edicoes) {
        this.gibi_id = gibi_id;
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoes = edicoes;
    }

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData, int edicoes) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoes = edicoes;

    }

    public Gibi() {
    }

    public Long getGibi_id() {
        return gibi_id;
    }

    public void setGibi_id(Long id) {
        this.gibi_id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getInicioData() {
        return inicioData;
    }

    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;
    }

    public LocalDate getEncData() {
        return encData;
    }

    public void setEncData(LocalDate encData) {
        this.encData = encData;
    }

    public int getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(int edicoes) {
        this.edicoes = edicoes;
    }

    @Id
    @SequenceGenerator(
            name = "gibi_sequence",
            sequenceName = "gibi_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gibi_sequence"
    )
    private Long gibi_id;
    private String titulo;
    private LocalDate inicioData;
    private LocalDate encData;
    private int edicoes;

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData, List<EdicoesGibi> edicoesGibis) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoes = edicoesGibis.size();
        this.edicoesGibis = edicoesGibis;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<EdicoesGibi> edicoesGibis;


    @Override
    public String toString() {
        return "gibi{" +
                "id=" + gibi_id +
                ", titulo='" + titulo + '\'' +
                ", inicioData=" + inicioData +
                ", encData=" + encData +
                ", edicoes=" + edicoes +
                '}';
    }

    public List<EdicoesGibi> getEdicoesGibis() {
        return edicoesGibis;
    }

    public void setEdicoesGibis(List<EdicoesGibi> edicoesGibis) {
        this.edicoesGibis = edicoesGibis;
    }
}
