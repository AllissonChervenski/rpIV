package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.editoragibi.editoragibi.Service.Domain.Transportadora;
import com.editoragibi.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("transportadoraBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransportadoraBuilder implements IBaseTransportadoraBuilder {

    private Transportadora transportadora;

    public TransportadoraBuilder() {
        reset();
    }

    private void reset() {
        transportadora = new Transportadora();
    }

    @Override
    public void setTransportadoraId(int transportadoraId) {
        transportadora.setTransportadoraId(transportadoraId);
    }

    @Override
    public void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException {
        try {
            transportadora.setNomeTransportadora(nomeTransportadora);
        } catch (TransportadoraInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException {
        try {
            transportadora.setEnderecoTransportadora(enderecoTransportadora);
        } catch (TransportadoraInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException {
        try {
            transportadora.setTelefoneTransportadora(telefoneTransportadora);
        } catch (TransportadoraInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public BaseTransportadora getResult() {
        Transportadora toReturn = transportadora;
        reset();
        return toReturn;
    }
}
