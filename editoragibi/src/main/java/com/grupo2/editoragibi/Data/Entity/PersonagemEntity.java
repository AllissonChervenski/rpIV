package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "personagem")
public class PersonagemEntity extends Personagem implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "personagem_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personagem_personagem_id_seq")
    private int personagemId;

    @Column(name = "nome_personagem")
    private String nomePersonagem;

    @Column(name = "historico_personagem")
    private String historicoPersonagem;

    @Column(name = "patente_personagem")
    private String patentePersonagem;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "escritor_personagem", joinColumns = {@JoinColumn(name = "personagem_id")}, inverseJoinColumns = {@JoinColumn(name = "escritor_id")})
    private List<EscritorEntity> escritores = new ArrayList<>();

    @ManyToMany(mappedBy = "personagemEntity")
    private List<EdicoesGibiEntity> edicoes = new ArrayList<>();

    public void setEscritores(List<EscritorEntity> escritores) {
        this.escritores = escritores;
    }

    @Override
    public List<Escritor> getEscritores(){
        return super.getEscritores();
    }
    public static Long getSerialversionuid() {
        return serialVersionUID;
    }
}
