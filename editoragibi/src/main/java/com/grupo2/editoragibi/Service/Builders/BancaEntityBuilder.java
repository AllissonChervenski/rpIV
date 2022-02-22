package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.BancaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseBanca;
import com.grupo2.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bancaEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BancaEntityBuilder implements IBaseBancaBuilder {

    private BancaEntity bancaEntity;

    public BancaEntityBuilder() {
        reset();
    }

    private void reset() {
        this.bancaEntity = new BancaEntity();
    }

    @Override
    public void setBancaId(int bancaId) {
        bancaEntity.setBancaId(bancaId);
    }

    @Override
    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException {
        bancaEntity.setNomeBanca(nomeBanca);
    }

    @Override
    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException {
        bancaEntity.setEnderecoBanca(enderecoBanca);
    }

    @Override
    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException {
        bancaEntity.setTelefoneBanca(telefoneBanca);
    }

    @Override
    public BaseBanca getResult() {
        BancaEntity toReturn = bancaEntity;
        reset();
        return toReturn;
    }
}
