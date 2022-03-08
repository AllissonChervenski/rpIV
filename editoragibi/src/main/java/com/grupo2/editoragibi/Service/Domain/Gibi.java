package com.grupo2.editoragibi.Service.Domain;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Gibi extends BaseGibi {

    //TODO private List<EdicoesGibi> edicoes = new ArrayList<>();

    @Override
    public void setTitulo(String titulo) throws GibiInvalidoException {
        if (titulo == null || !Pattern.matches("([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,20}$", titulo))
            throw new GibiInvalidoException("O título do gibi não é válido");
        this.titulo = titulo;
    }

    @Override
    public void setInicioData(LocalDate inicioData) throws GibiInvalidoException {
        if (inicioData == null || inicioData.isAfter(LocalDate.now()))
            throw new GibiInvalidoException("A data de publicação do gibi não é válida");
        this.inicioData = inicioData;
    }

    @Override
    public void setEncData(LocalDate encData) throws GibiInvalidoException {
        if (encData == null || encData.isAfter(LocalDate.now()))
            throw new GibiInvalidoException("A data de encerramento da publicação do gibi não é válida");
        this.encData = encData;
    }
}
