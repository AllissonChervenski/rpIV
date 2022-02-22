package com.grupo2.editoragibi.Service.Domain;

import com.grupo2.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;

import java.util.regex.Pattern;

public class Transportadora extends BaseTransportadora {

    @Override
    public void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException {
        if (nomeTransportadora == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,20}$", nomeTransportadora))
            throw new TransportadoraInvalidaException("Nome da transportadora é inválido");
        this.nomeTransportadora = nomeTransportadora;
    }

    @Override
    public void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException {
        if (enderecoTransportadora == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,25}$", enderecoTransportadora))
            throw new TransportadoraInvalidaException("Endereço da transportadora é inválido");
        this.enderecoTransportadora = enderecoTransportadora;
    }

    @Override
    public void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException {
        if (telefoneTransportadora == null || !Pattern.matches("^\\d{11}$", telefoneTransportadora))
            throw new TransportadoraInvalidaException("Telefone da transportadora é inválido");
        this.telefoneTransportadora = telefoneTransportadora;
    }
}
