package com.grupo2.editoragibi.Data.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "personagem")
public class PersonagemEntity implements Serializable {

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
    private List<EscritorEntity> escritores;

    public void setEscritores(List<EscritorEntity> escritores) {
        this.escritores = escritores;
    }
}
