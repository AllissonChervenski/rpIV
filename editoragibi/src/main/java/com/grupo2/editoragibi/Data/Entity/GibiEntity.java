package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;


import com.grupo2.editoragibi.Service.Domain.Gibi;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "gibi")
public class GibiEntity extends BaseGibi {

    @Id
    @Column(name = "gibi_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gibi_gibi_id_seq")
    private int gibiId;

    @Column(name = "titulo_gibi")
    private String tituloGibi;

    @Column(name = "data_inicio_publi")
    private LocalDate inicioData;

    @Column(name = "data_encerramento")
    private LocalDate encData;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gibi")
    private List<EdicoesGibiEntity> edicoesGibis = new ArrayList<>();


    public void setEdicaoGibi(EdicoesGibiEntity edicoes) {
        this.edicoesGibis.add(edicoes);
    }
}