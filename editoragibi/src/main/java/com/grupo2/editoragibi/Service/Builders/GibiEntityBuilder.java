package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("gibiEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GibiEntityBuilder implements IBaseGibiBuilder {

    private GibiEntity gibiEntity;

    public GibiEntityBuilder() {
        reset();
    }

    private void reset() {
        gibiEntity = new GibiEntity();
    }

    @Override
    public void setGibiId(int id) {
        gibiEntity.setGibiId(id);
    }

    @Override
    public void setTituloGibi(String titulo) throws GibiInvalidoException {
        gibiEntity.setTitulo(titulo);
    }

    @Override
    public void setInicioDataGibi(LocalDate inicioData) throws GibiInvalidoException {
        gibiEntity.setInicioData(inicioData);
    }

    @Override
    public void setEncDataGibi(LocalDate encData) throws GibiInvalidoException {
        gibiEntity.setEncData(encData);
    }

    @Override
    public BaseGibi getResult() {
        GibiEntity toReturn = gibiEntity;
        reset();
        return toReturn;
    }
}
