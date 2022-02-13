package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;

public interface IBaseBancaBuilder {

    public void setBancaId(int bancaId);

    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException;

    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException;

    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException;

    public BaseBanca getResult();
}
