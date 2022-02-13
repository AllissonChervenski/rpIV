package com.editoragibi.editoragibi.Api.Requests;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.editoragibi.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
import lombok.Data;

@Data
public class TransportadoraRequest extends BaseTransportadora {
    @Override
    public void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException {
        this.nomeTransportadora = nomeTransportadora;
    }

    @Override
    public void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException {
        this.enderecoTransportadora = enderecoTransportadora;
    }

    @Override
    public void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException {
        this.telefoneTransportadora = telefoneTransportadora;
    }
}
