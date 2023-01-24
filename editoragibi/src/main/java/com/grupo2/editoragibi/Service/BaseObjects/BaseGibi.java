package com.grupo2.editoragibi.Service.BaseObjects;

import java.time.LocalDate;

import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

public abstract class BaseGibi {

    protected Integer gibi_id;
    protected String tituloGibi;
    protected LocalDate inicioData;
    protected LocalDate encData;


    public Integer getGibi_id() {
        return gibi_id;
    }
    public void setGibi_id(Integer gibi_id) {
        this.gibi_id = gibi_id;
    }

    public String getTituloGibi() {
        return tituloGibi;
    }
    public void setTituloGibi(String tituloGibi) throws GibiInvalidoException {
        this.tituloGibi = tituloGibi;
    }
    public LocalDate getInicioData() {
        return inicioData;
    }
    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;
    }
    public LocalDate getEncData() {
        return encData;
    }
    public void setEncData(LocalDate encData) {
        this.encData = encData;
    }



}