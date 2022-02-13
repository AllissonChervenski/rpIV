package com.editoragibi.editoragibi.Service.Domain;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;

import java.util.regex.Pattern;

public class Banca extends BaseBanca {
    @Override
    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException {
        if (nomeBanca == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,20}$", nomeBanca))
            throw new BancaInvalidaException("Nome da banca é inválido");
        this.nomeBanca = nomeBanca;
    }

    @Override
    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException {
        if (enderecoBanca == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,25}$", enderecoBanca))
            throw new BancaInvalidaException("O endereço da banca é inválido");
        this.enderecoBanca = enderecoBanca;
    }

    @Override
    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException {
        if (telefoneBanca == null || !Pattern.matches("^\\d{11}$", telefoneBanca))
            throw new BancaInvalidaException("O telefone da banca é inválido");
        this.telefoneBanca = telefoneBanca;
    }
}
