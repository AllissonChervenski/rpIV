package com.editoragibi.editoragibi.gibi;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Gibi {
    public Gibi(Long id, String titulo, LocalDate inicioData, LocalDate encData, int edicoes) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private Long id;
    private String titulo;
    private LocalDate inicioData;
    private LocalDate encData;
    private int edicoes;

    @Override
    public String toString() {
        return "gibi{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", inicioData=" + inicioData +
                ", encData=" + encData +
                ", edicoes=" + edicoes +
                '}';
    }
}
