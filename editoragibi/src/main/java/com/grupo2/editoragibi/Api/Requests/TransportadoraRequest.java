package com.grupo2.editoragibi.Api.Requests;

import com.grupo2.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
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
