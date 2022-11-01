package com.grupo2.editoragibi.Service.BaseObjects;

import java.time.LocalDate;

public abstract class BaseGibi {
    
    protected Long gibi_Id;
    protected String tituloGibi;
    protected LocalDate inicioData;
    protected LocalDate encData;
    
   
    public Long getGibi_Id() {
        return gibi_Id;
    }
    public void setGibi_Id(Long gibi_Id) {
        this.gibi_Id = gibi_Id;
    }
    public String getTituloGibi() {
        return tituloGibi;
    }
    public void setTituloGibi(String tituloGibi) {
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
