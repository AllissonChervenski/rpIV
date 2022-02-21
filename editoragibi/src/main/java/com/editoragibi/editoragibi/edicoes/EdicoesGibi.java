package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
public class EdicoesGibi {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator =  "edicoes_edicoes_id_seq"
    )
    @Column(name = "edicao_id")
    private long edicaoGibiId;

    @Column(name = "numero_edicao")
    private int nroEdicao;

    @Column(name = "data_edicao")
    private LocalDate dataPub;

    @Column(name = "publicada_edicao")
    private boolean publicada;

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
