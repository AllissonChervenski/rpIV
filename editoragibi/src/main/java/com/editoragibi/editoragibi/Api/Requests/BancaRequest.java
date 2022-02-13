package com.editoragibi.editoragibi.Api.Requests;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;

public class BancaRequest extends BaseBanca {
    @Override
    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException {
        this.nomeBanca = nomeBanca;
    }

    @Override
    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException {
        this.enderecoBanca = enderecoBanca;
    }

    @Override
    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException {
        this.telefoneBanca = telefoneBanca;
    }
}
