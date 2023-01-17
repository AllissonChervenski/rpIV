package com.grupo2.editoragibi.Service.Builders.Interfaces;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

import java.time.LocalDate;

public interface IBaseGibiBuilder {

    public void setGibiId(int id);

    public void setTituloGibi(String tituloGibi) throws GibiInvalidoException;

    public void setInicioData(LocalDate inicioData) throws GibiInvalidoException;

    public void setEncData(LocalDate encData) throws GibiInvalidoException;

    public BaseGibi getResult();
}
