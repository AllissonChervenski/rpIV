package com.grupo2.editoragibi.Api.Requests;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;

import lombok.Data;

@Data
public class GibiRequest extends BaseGibi{

    @NotNull
    private List<Integer> edicoesGibiId;

    @Override
    public LocalDate getEncData() {
        // TODO Auto-generated method stub
        return this.encData;
    }


    @Override
    public LocalDate getInicioData() {
        // TODO Auto-generated method stub
        return this.inicioData;
    }

    @Override
    public String getTituloGibi() {
        // TODO Auto-generated method stub
        return this.tituloGibi;
    }


    public void setEdicoesGibiId(List<Integer> edicoesGibiId) {
        this.edicoesGibiId = edicoesGibiId;
    }

    @Override
    public void setEncData(LocalDate encData) {
        this.encData = encData;

    }

    @Override
    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;

    }

    @Override
    public void setTituloGibi(String tituloGibi) {
        this.tituloGibi = tituloGibi;
    }


}