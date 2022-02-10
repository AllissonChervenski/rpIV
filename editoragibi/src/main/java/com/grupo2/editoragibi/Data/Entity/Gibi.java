package com.grupo2.editoragibi.Data.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Gibi {

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData, List<EdicoesGibi> edicoesGibis) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoesGibis = edicoesGibis;
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

    public List<EdicoesGibi> getEdicoesGibis() {
        return edicoesGibis;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<EdicoesGibi> edicoesGibis;

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoesGibis = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "gibi{" +
                "id=" + gibi_id +
                ", titulo='" + titulo + '\'' +
                ", inicioData=" + inicioData +
                ", encData=" + encData +
                ", edicoesGibis=" + edicoesGibis +
                '}';
    }


    public void setEdicoesGibis(List<EdicoesGibi> edicoesGibis) {
        this.edicoesGibis = edicoesGibis;
    }


}
