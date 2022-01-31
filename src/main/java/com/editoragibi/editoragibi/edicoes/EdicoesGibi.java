package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table
public class EdicoesGibi {

    @Id
    @SequenceGenerator(
            name = "edicoesGibi_sequence",
            sequenceName = "edicoesGibi_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "edicoesGibi_sequence"
    )
    private long id;
    private int edicao;
    private LocalDate dataPub;

    @ManyToOne
    private Gibi gibi;

    public Gibi getGibi() {
        return gibi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataPub() {
        return dataPub;
    }

    public void setDataPub(LocalDate dataPub) {
        this.dataPub = dataPub;
    }

    public EdicoesGibi(long id, int edicao, LocalDate dataPub) {
        this.id = id;
        this.edicao = edicao;
        this.dataPub = dataPub;
    }


    public EdicoesGibi(int edicao, LocalDate dataPub) {
        this.edicao = edicao;
        this.dataPub = dataPub;
    }

    public EdicoesGibi() {
    }


}
