package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Table(name ="desenhista")
@Entity
public class DesenhistaEntity extends BaseDesenhista implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "desenhista_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator ="desenhista_desenhista_id_seq")
    private int desenhistaId;

    @Column(name = "nome_desenhista")
    private String nomeDesenhista;

    @Column(name = "pais_nascimento")
    private String paisNascimento;

    @Column(name = "data_nascimento_desenhista")
    private LocalDate dataNascimento;

    @Column(name = "data_falecimento_desenhista")
    private LocalDate dataFalecimento;

    @Column(name = "endereco_desenhista")
    private String enderecoDesenhista;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    @Column(name = "data_demissao")
    private LocalDate dataDemissao;
}
