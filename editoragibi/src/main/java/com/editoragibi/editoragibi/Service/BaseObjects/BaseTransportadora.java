package com.editoragibi.editoragibi.Service.BaseObjects;

import com.editoragibi.editoragibi.Service.Exceptions.TransportadoraInvalidaException;

public abstract class BaseTransportadora {

    protected int transportadoraId;
    protected String nomeTransportadora;
    protected String enderecoTransportadora;
    protected String telefoneTransportadora;

    public void setTransportadoraId(int transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    public int getTransportadoraId() {
        return transportadoraId;
    }

    public abstract void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException;

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public abstract void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException;

    public String getEnderecoTransportadora() {
        return enderecoTransportadora;
    }

    public abstract void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException;

    public String getTelefoneTransportadora() {
        return telefoneTransportadora;
    }
}
