package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Service.BaseObjects.BaseBanca;
import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;

public interface IBaseBancaBuilder {

    public void setBancaId(int bancaId);

    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException;

    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException;

    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException;

    public BaseBanca getResult();
}
