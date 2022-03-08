package com.grupo2.editoragibi.Data.Entity;


import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "gibi")
public class GibiEntity extends BaseGibi {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "gibi_gibi_id_seq"
    )
    @Column(name = "gibi_id")
    private int gibiId;

    @Column(name = "titulo_gibi")
    private String titulo;

    @Column(name = "data_inicio_publi")
    private LocalDate inicioData;

    @Column(name = "data_encerramento")
    private LocalDate encData;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gibi")
    //TODO esse campo tem que ser o EdicoesGibiEntity
    private List<EdicoesGibi> edicoesGibis;

    public void setEdicoesGibis(List<EdicoesGibi> edicoesGibis) {
        this.edicoesGibis = edicoesGibis;
    }

    public void setGibiId(int id) {
        this.gibiId = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;
    }

    public void setEncData(LocalDate encData) {
        this.encData = encData;
    }

    public List<EdicoesGibi> getEdicoesGibis() {
        return edicoesGibis;
    }
}