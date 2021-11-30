package com.grupo2.editoragibi.Data.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "gibi")
@Entity
public class GibiEntity implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "gibi_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gibi_gibi_id_seq")
    private int id;

    @Column(name = "titulo_gibi")
    private String titulo;

    @Column(name = "data_inicio_publi")
    private LocalDate inicioData;

    @Column(name = "data_encerramento")
    private LocalDate encData;


}

