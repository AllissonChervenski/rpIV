package com.grupo2.editoragibi.Data.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.editor.Editor;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table(name = "edicao")
public class EdicoesGibiEntity extends EdicoesGibi{

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator =  "edicao_edicao_id_seq"
    )
    @Column(name = "edicao_id")
    private int edicaoGibi_id;

    @Column(name = "numero_edicao")
    private int nroEdicao;

    @Column(name = "data_edicao")
    private LocalDate dataPub;

    @Column(name = "publicada_edicao")
    private boolean publicada;

    @Column(name = "numero_exemplares_impressos")
    private int numeroExemplaresImpressas;

    @ManyToOne
    @JoinColumn(name = "gibi_id")
    private GibiEntity gibiEntity;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_historia", joinColumns = {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "historia_id")})
    private HistoriaEntity historiaEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "edicoes_escritor", joinColumns = {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "escritor_id")})
    private List<EscritorEntity> escritorEntity = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_personagem", joinColumns =  {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "personagem_id")})
    private List<PersonagemEntity> personagemEntity = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_desenhista", joinColumns ={@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "desenhista_id")})
    private List<DesenhistaEntity> desenhistaEntity = new ArrayList<>();




}
