package com.grupo2.editoragibi.Service.BaseObjects;

import java.time.LocalDate;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Domain.Editora;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;

public abstract class BaseEdicoesGibi {

    protected int edicaoGibi_id;
    protected int nroEdicao;
    protected LocalDate dataPub;
    protected boolean publicada;
    protected int numeroExemplaresImpressas;

    protected Gibi gibi;
    protected Historia historia;
    protected Editora editora;

    public Editora getEditora() {
        return editora;
    }
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public int getNumeroExemplaresImpressas() {
        return numeroExemplaresImpressas;
    }
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        this.numeroExemplaresImpressas = numeroExemplaresImpressas;
    }
    public Gibi getGibi() {
        return gibi;
    }
    public abstract void setGibi(Gibi gibi) throws EdicoesGibiInvalidoException, GibiInvalidoException;

    public BaseHistoria getHistoria() {
        return historia;
    }
    public abstract void setHistoria(Historia historia) throws HistoriaInvalidaException;

    public int getEdicaoGibi_id() {
        return edicaoGibi_id;
    }
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        this.edicaoGibi_id = edicaoGibi_id;
    }
    public int getNroEdicao() {
        return nroEdicao;
    }
    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException {
        this.nroEdicao = nroEdicao;
    }
    public LocalDate getDataPub() {
        return dataPub;
    }
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        this.dataPub = dataPub;
    }
    public boolean isPublicada() {
        return publicada;
    }
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }


}