package com.grupo2.editoragibi.Api.Requests;

import java.time.LocalDate;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;

public class EdicoesGibiRequest extends BaseEdicoesGibi{

    @Override
    public LocalDate getDataPub() {
        // TODO Auto-generated method stub
        return super.getDataPub();
    }

    @Override
    public int getNroEdicao() {
        // TODO Auto-generated method stub
        return super.getNroEdicao();
    }

    @Override
    public boolean isPublicada() {
        // TODO Auto-generated method stub
        return super.isPublicada();
    }

    @Override
    public void setDataPub(LocalDate dataPub) {
        // TODO Auto-generated method stub
        super.setDataPub(dataPub);
    }

    @Override
    public void setNroEdicao(int nroEdicao) {
        // TODO Auto-generated method stub
        super.setNroEdicao(nroEdicao);
    }

    @Override
    public void setPublicada(boolean publicada) {
        // TODO Auto-generated method stub
        super.setPublicada(publicada);
    }
    
    
}
