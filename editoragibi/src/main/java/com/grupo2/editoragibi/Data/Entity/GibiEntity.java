package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;


import com.grupo2.editoragibi.Service.Domain.Gibi;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "gibi")
public class GibiEntity extends Gibi {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gibi")
    private List<EdicoesGibiEntity> edicoesGibis;


    public void setEdicoesGibis(List<EdicoesGibiEntity> edicoesGibi) {
        this.edicoesGibis = edicoesGibi;
    }

    public List<EdicoesGibiEntity> getEdicoesGibis() {
        return this.edicoesGibis;
    }

    public void setEdicaoGibi(EdicoesGibiEntity edicoes) {
        this.edicoesGibis.add(edicoes);
    }
}