package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "gibi")
public class GibiEntity extends BaseGibi{

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "gibi_gibi_id_seq"
    )
    @Column(name = "gibi_id")
    private Integer gibi_id;

    @Column(name = "titulo_gibi")
    private String tituloGibi;

    @Column(name = "data_inicio_publi")
    private LocalDate inicioData;

    @Column(name = "data_encerramento")
    private LocalDate encData;

    @Column( name =  "descontinuado_gibi")
    private String descontinuadoGibi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gibi")
    private List<EdicoesGibiEntity> edicoesGibis;
 

    public GibiEntity(String titulo, LocalDate inicioData, LocalDate encData, List<EdicoesGibiEntity> edicoesGibis, String descontinuadoGibi) {
        this.tituloGibi = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.edicoesGibis = edicoesGibis;
        this.descontinuadoGibi = descontinuadoGibi;
    }

    public GibiEntity(String titulo, LocalDate inicioData, LocalDate encData, String descontinuadoGibi) {
        this.tituloGibi = titulo;
        this.inicioData = inicioData;
        this.encData = encData;
        this.descontinuadoGibi = descontinuadoGibi;
        this.edicoesGibis = new ArrayList<>();
    }

    public GibiEntity() {
    }

    public void setEdicoesGibis(List<EdicoesGibiEntity> edicoesGibis) {
        this.edicoesGibis = edicoesGibis;
    }

    public Integer getGibi_id() {
        return gibi_id;
    }


    public void setGibi_id(Integer id){
        this.gibi_id = id;
    }

    public String getTitulo() {
        return tituloGibi;
    }

    public void setTitulo(String titulo) {
        this.tituloGibi = titulo;
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
    public String getDescontinuado() {
        return descontinuadoGibi;
    }

    public void setDescontinuado(String descontinuadoGibi) {
        this.descontinuadoGibi = descontinuadoGibi;
    } 
    public List<EdicoesGibiEntity> getEdicoesGibis() {
        return edicoesGibis;
    }
}