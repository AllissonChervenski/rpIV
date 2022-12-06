package com.grupo2.editoragibi.Api.Requests;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;

import lombok.Data;

@Data
public class GibiRequest extends BaseGibi{

    @NotNull
    private List<Long> edicoesGibiId;
    public void setEdicoesGibiId(List<Long> edicoesGibiId) {
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
