package com.grupo2.editoragibi.Data.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
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
public class HistoriaEntity extends Historia  {

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
    private DesenhistaEntity artefinalizadorEntity;

    @ManyToOne
    @JoinColumn(name = "desenhista_desenha_id")
    private DesenhistaEntity desenhistaEntity;

    @ManyToOne
    @JoinColumn(name = "escritor_id")
    private EscritorEntity escritorEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "historia_personagem", joinColumns = {@JoinColumn(name = "historia_id")}, inverseJoinColumns = {@JoinColumn(name = "personagem_id")})
    List<PersonagemEntity> personagensEntity = new ArrayList<>();

    @OneToOne(mappedBy = "historiaEntity")
    private EdicoesGibiEntity edicoesGibiEntity;
    



}
