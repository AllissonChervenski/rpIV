package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.List;

public interface IBasePersonagemBuilder {

    public void setPersonagemId(int id);

    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException;

    public void setHistoriaPersonagem(String historiaPersonagem);

    public void setPatentePersonagem(String patentePersonagem);

    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException;

    public void setEscritores(List<Integer> escritoresIds) throws PersonagemInvalidoException, EscritorInvalidoException;

    public BasePersonagem getResult();
}
