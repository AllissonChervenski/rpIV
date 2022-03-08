package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("gibiBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GibiBuilder implements IBaseGibiBuilder {

    private Gibi gibi;

    public GibiBuilder() {
        reset();
    }

    private void reset() {
        gibi = new Gibi();
    }

    @Override
    public void setGibiId(int id) {
        gibi.setGibiId(id);
    }

    @Override
    public void setTituloGibi(String titulo) throws GibiInvalidoException {
        try {
            gibi.setTitulo(titulo);
        } catch (GibiInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setInicioDataGibi(LocalDate inicioData) throws GibiInvalidoException {
        try {
            gibi.setInicioData(inicioData);
        } catch (GibiInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEncDataGibi(LocalDate encData) throws GibiInvalidoException {
        try {
            gibi.setEncData(encData);
        } catch (GibiInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public BaseGibi getResult() {
        Gibi toReturn = gibi;
        reset();
        return toReturn;
    }
}
