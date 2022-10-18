package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.TransportadoraEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseTransportadora;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("transportadoraEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransportadoraEntityBuilder implements IBaseTransportadoraBuilder {

    private TransportadoraEntity transportadoraEntity;

    public TransportadoraEntityBuilder() {
        reset();
    }

    private void reset() {
        transportadoraEntity = new TransportadoraEntity();
    }

    @Override
    public void setTransportadoraId(int transportadoraId) {
        transportadoraEntity.setTransportadoraId(transportadoraId);
    }

    @Override
    public void setNomeTransportadora(String nomeTransportadora) throws TransportadoraInvalidaException {
        transportadoraEntity.setNomeTransportadora(nomeTransportadora);
    }

    @Override
    public void setEnderecoTransportadora(String enderecoTransportadora) throws TransportadoraInvalidaException {
        transportadoraEntity.setEnderecoTransportadora(enderecoTransportadora);
    }

    @Override
    public void setTelefoneTransportadora(String telefoneTransportadora) throws TransportadoraInvalidaException {
        transportadoraEntity.setTelefoneTransportadora(telefoneTransportadora);
    }

    @Override
    public BaseTransportadora getResult() {
        TransportadoraEntity toReturn = transportadoraEntity;
        reset();
        return toReturn;
    }
}
