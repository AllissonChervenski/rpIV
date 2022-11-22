package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "historia")
public class HistoriaEntity extends BaseHistoria implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "historia_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "historia_historia_id_seq")
    private int historiaId;

    @Column(name = "titulo_historia")
    private String tituloHistoria;

    @Column(name = "total_paginas")
    private int totalPaginas;

    @Column(name = "data_producao")
    private LocalDate dataProducao;

    @ManyToOne
    @JoinColumn(name = "desenhista_artefinaliza_id")
    private DesenhistaEntity artefinalizador;

    @ManyToOne
    @JoinColumn(name = "desenhista_desenha_id")
    private DesenhistaEntity desenhista;

    @ManyToOne
    @JoinColumn(name = "escritor_id")
    private EscritorEntity escritor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "historia_personagem", joinColumns = {@JoinColumn(name = "historia_id")}, inverseJoinColumns = {@JoinColumn(name = "personagem_id")})
    List<PersonagemEntity> personagens = new ArrayList<>();

    @OneToOne(mappedBy = "historia")
    private EdicoesGibiEntity edicoesGibi;
    
    @Override
    public void setArtefinalizador(BaseDesenhista artefinalizador) throws HistoriaInvalidaException, DesenhistaInvalidoException {
        this.artefinalizador = (DesenhistaEntity) artefinalizador;
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) throws DesenhistaInvalidoException {
        this.desenhista = (DesenhistaEntity) desenhista;
    }

    @Override
    public void setEscritor(BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException {
        this.escritor = (EscritorEntity) escritor;
    }
}
