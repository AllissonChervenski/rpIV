package com.grupo2.editoragibi.Data.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Table(name = "desenhista")
@Entity
public class DesenhistaEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name = "nome")
    private String nomeDesenhista;

    @Column(name = "endereco")
    private String enderecoDesenhista;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    @Column(name = "data_demissao")
    private LocalDate dataDemissao;
}
