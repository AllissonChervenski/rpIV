package com.grupo2.editoragibi.Service.Builders.Interfaces;

import com.grupo2.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;

public interface IBaseTransportadoraBuilder {

    public void setTransportadoraId(int transportadoraId);

    public void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException;

    public void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException;

    public void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException;

    public BaseTransportadora getResult();
}
