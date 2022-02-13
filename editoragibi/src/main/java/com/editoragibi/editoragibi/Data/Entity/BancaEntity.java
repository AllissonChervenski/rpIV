package com.editoragibi.editoragibi.Data.Entity;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "banca")
public class BancaEntity extends BaseBanca {

    @Id
    @Column(name = "banca_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "banca_banca_id_seq")
    private int bancaId;

    @Column(name = "nome_banca")
    private String nomeBanca;

    @Column(name = "endereco_banca")
    private String enderecoBanca;

    @Column(name = "telefone_banca")
    private String telefoneBanca;
}
