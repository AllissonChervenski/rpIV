package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "escritor")
public class EscritorEntity extends BaseEscritor implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "escritor_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "escritor_escritor_id_seq")
    private int escritorId;

    @Column(name = "nome_escritor")
    private String nomeEscritor;

    
    @Column(name = "pais_nascimento")
    private String paisNascimentoEs;

    @Column(name = "data_nascimento_escritor")
    private LocalDate dataNascimentoEs;

    @Column(name = "data_falecimento_escritor")
    private LocalDate dataFalecimentoEs;

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
    private List<PersonagemEntity> personagens = new ArrayList<>();
}
