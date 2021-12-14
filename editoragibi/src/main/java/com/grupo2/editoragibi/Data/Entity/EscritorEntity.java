package com.grupo2.editoragibi.Data.Entity;

import com.fasterxml.jackson.annotation.*;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "escritor")
public class EscritorEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "escritor_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "escritor_escritor_id_seq")
    private int escritorId;

    @Column(name = "nome_escritor")
    private String nomeEscritor;

    @Column(name = "endereco_escritor")
    private String enderecoEscritor;

    @Column(name = "telefone_escritor")
    private String telefoneEscritor;

    @Column(name = "email_escritor")
    private String emailEscritor;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    @Column(name = "data_demissao")
    private LocalDate dataDemissao;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "escritores")
    private List<PersonagemEntity> personagens;
}