package com.grupo2.editoragibi.Data.Entity;


import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "gibi")
public class Gibi {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gibi_sequence"
    )
    @Column(name = "gibi_id")
    private Long gibi_id;

    @Column(name = "titulo_gibi")
    private String titulo;

    @Column(name = "data_inicio_publi")
    private LocalDate inicioData;

    @Column(name = "data_encerramento")
    private LocalDate encData;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gibi")
    private List<EdicoesGibi> edicoesGibis;

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData, List<EdicoesGibi> edicoesGibis) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoesGibis = edicoesGibis;
    }

    public Gibi(String titulo, LocalDate inicioData, LocalDate encData) {
        this.titulo = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoesGibis = new ArrayList<>();
    }

    public Gibi() {
    }

    public void setEdicoesGibis(List<EdicoesGibi> edicoesGibis) {
        this.edicoesGibis = edicoesGibis;
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

    public List<EdicoesGibi> getEdicoesGibis() {
        return edicoesGibis;
    }
}