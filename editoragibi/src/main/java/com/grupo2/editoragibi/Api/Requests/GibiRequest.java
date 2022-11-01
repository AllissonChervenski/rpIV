package com.grupo2.editoragibi.Api.Requests;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;


public class GibiRequest extends BaseGibi{

    @NotNull
    private List<Long> edicoesGibiId;

    @Override
    public LocalDate getEncData() {
        // TODO Auto-generated method stub
        return super.getEncData();
    }


    @Override
    public LocalDate getInicioData() {
        // TODO Auto-generated method stub
        return super.getInicioData();
    }

    @Override
    public String getTituloGibi() {
        // TODO Auto-generated method stub
        return super.getTituloGibi();
    }

    @Override
    public void setEncData(LocalDate encData) {
        // TODO Auto-generated method stub
        super.setEncData(encData);
    }

    @Override
    public void setInicioData(LocalDate inicioData) {
        // TODO Auto-generated method stub
        super.setInicioData(inicioData);
    }

    @Override
    public void setTituloGibi(String tituloGibi) {
        // TODO Auto-generated method stub
        super.setTituloGibi(tituloGibi);
    }
    
}
