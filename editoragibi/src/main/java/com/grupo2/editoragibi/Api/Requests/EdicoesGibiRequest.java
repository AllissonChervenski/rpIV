package com.grupo2.editoragibi.Api.Requests;

import java.time.LocalDate;
import java.util.List;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;

import lombok.Data;

@Data
public class EdicoesGibiRequest extends BaseEdicoesGibi{


    private List<Integer> personagensId;
    private List<Integer> historiasId;
    private List<Integer> desenhistasId;
    private List<Integer> escritorId;
    
    private Integer gibiId;
    private Integer editorId;
    
    @Override
    public LocalDate getDataPub() {
        // TODO Auto-generated method stub
        return this.dataPub;
    }

    @Override
    public int getNroEdicao() {
        // TODO Auto-generated method stub
        return this.nroEdicao;
    }

    @Override
    public boolean isPublicada() {
        // TODO Auto-generated method stub
        return this.publicada;
    }

    @Override
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        this.dataPub = dataPub;
    }

    @Override
    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
       this.nroEdicao = nroEdicao;
    }

    @Override
    public void setPublicada(boolean publicada) {
        // TODO Auto-generated method stub
        this.publicada = publicada;
    }

    @Override
    public void setGibi(BaseGibi gibi) throws EdicoesGibiInvalidoException, GibiInvalidoException {
        // TODO Auto-generated method stub
        this.gibi = gibi;
    }

    @Override
    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException {
        // TODO Auto-generated method stub
        this.historia = historia;
    }
    
    
}
