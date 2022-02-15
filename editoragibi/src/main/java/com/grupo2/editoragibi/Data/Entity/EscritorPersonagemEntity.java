package com.grupo2.editoragibi.Data.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "escritor_personagem")
public class EscritorPersonagemEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "escritor_id")
    private int escritorId;

    @Id
    @Column(name = "personagem_id")
    private int personagemId;

}
