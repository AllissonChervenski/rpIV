package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;

import javax.persistence.*;
import java.time.LocalDate;


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
    private long edicaoGibiId;
    private int nroEdicao;
    private LocalDate dataPub;

    public EdicoesGibi(int nroEdicao, LocalDate dataPub) {
        this.nroEdicao = nroEdicao;
        this.dataPub = dataPub;
    }


    public long getEdicaoGibiId() {
        return edicaoGibiId;
    }

    public void setEdicaoGibiId(long id) {
        this.edicaoGibiId = id;
    }

    public int getNroEdicao() {
        return nroEdicao;
    }

    public void setNroEdicao(int nroEdicao) {
        this.nroEdicao = nroEdicao;
    }

    public LocalDate getDataPub() {
        return dataPub;
    }

    public void setDataPub(LocalDate dataPub) {
        this.dataPub = dataPub;
    }


    public EdicoesGibi(long edicaoGibiId, int nroEdicao, LocalDate dataPub) {
        this.edicaoGibiId = edicaoGibiId;
        this.nroEdicao = nroEdicao;
        this.dataPub = dataPub;
    }


    public EdicoesGibi() {
    }



}
