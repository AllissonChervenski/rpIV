package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

import java.time.LocalDate;

public interface IBaseGibiBuilder {

    public void setGibiId(int id);

    public void setTituloGibi(String titulo) throws GibiInvalidoException;

    public void setInicioDataGibi(LocalDate inicioData) throws GibiInvalidoException;

    public void setEncDataGibi(LocalDate encData) throws GibiInvalidoException;

    public BaseGibi getResult();
}
