package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseBanca;
import com.editoragibi.editoragibi.Service.Domain.Banca;
import com.editoragibi.editoragibi.Service.Exceptions.BancaInvalidaException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bancaBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BancaBuilder implements IBaseBancaBuilder {

    private Banca banca;

    public BancaBuilder() {
        reset();
    }

    private void reset() {
        this.banca = new Banca();
    }


    @Override
    public void setBancaId(int bancaId) {
        banca.setBancaId(bancaId);
    }

    @Override
    public void setNomeBanca(String nomeBanca) throws BancaInvalidaException {
        try {
            banca.setNomeBanca(nomeBanca);
        } catch (BancaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEnderecoBanca(String enderecoBanca) throws BancaInvalidaException {
        try {
            banca.setEnderecoBanca(enderecoBanca);
        } catch (BancaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setTelefoneBanca(String telefoneBanca) throws BancaInvalidaException {
        try {
            banca.setTelefoneBanca(telefoneBanca);
        } catch (BancaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public BaseBanca getResult() {
        Banca toReturn = banca;
        reset();
        return toReturn;
    }
}
