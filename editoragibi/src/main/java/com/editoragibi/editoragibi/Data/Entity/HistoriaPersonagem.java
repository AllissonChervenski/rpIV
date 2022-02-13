package com.editoragibi.editoragibi.Data.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "historia_personagem")
public class HistoriaPersonagem implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "historia_id")
    private int historiaId;

    @Id
    @Column(name = "personagem_id")
    private int personagemId;
}
