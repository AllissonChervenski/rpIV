package com.grupo2.editoragibi.Service.BaseObjects;

import java.time.LocalDate;

public class BaseEdicoesGibi {
    protected int edicaoGibi_id;
    protected int nroEdicao;
    protected LocalDate dataPub;
    protected boolean publicada;
    
    public int getEdicaoGibi_id() {
        return edicaoGibi_id;
    }
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        this.edicaoGibi_id = edicaoGibi_id;
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
    public boolean isPublicada() {
        return publicada;
    }
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    
}
