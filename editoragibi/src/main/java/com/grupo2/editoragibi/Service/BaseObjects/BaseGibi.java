package com.grupo2.editoragibi.Service.BaseObjects;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

import java.time.LocalDate;
import java.util.List;

public abstract class BaseGibi {

    protected int gibiId;
    protected String titulo;
    protected LocalDate inicioData;
    protected LocalDate encData;
    //TODO protected List<EdicoesGibi> edicoesGibis;

    public void setGibiId(int gibiId) {
        this.gibiId = gibiId;
    }

    public int getGibiId() {
        return gibiId;
    }

    public abstract void setTitulo(String titulo) throws GibiInvalidoException;

    public String getTitulo() {
        return titulo;
    }

    public abstract void setInicioData(LocalDate inicioData) throws GibiInvalidoException;

    public LocalDate getInicioData() {
        return inicioData;
    }

    public abstract void setEncData(LocalDate encData) throws GibiInvalidoException;

    public LocalDate getEncData() {
        return encData;
    }
}
