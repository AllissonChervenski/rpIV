package com.grupo2.editoragibi.Service.BaseObjects;

import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;

public abstract class BaseBanca {

    protected int bancaId;
    protected String nomeBanca;
    protected String enderecoBanca;
    protected String telefoneBanca;

    public int getBancaId() {
        return bancaId;
    }

    public void setBancaId(int bancaId) {
        this.bancaId = bancaId;
    }

    public String getNomeBanca() {
        return nomeBanca;
    }

    public abstract void setNomeBanca(String nomeBanca) throws BancaInvalidaException;

    public String getEnderecoBanca() {
        return enderecoBanca;
    }

    public abstract void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException;

    public String getTelefoneBanca() {
        return telefoneBanca;
    }

    public abstract void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException;
}
