package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.BaseObjects.BaseBanca;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "banca")
public class BancaEntity extends BaseBanca implements Serializable {

    public static final Long serialVersionUID = 1L;

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
