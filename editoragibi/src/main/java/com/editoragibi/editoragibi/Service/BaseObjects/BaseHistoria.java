package com.editoragibi.editoragibi.Service.BaseObjects;

import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;

public abstract class BaseHistoria {

    protected int historiaId;
    protected String tituloHistoria;
    protected int totalPaginas;
    protected LocalDate dataProducao;
    //os campos a seguir tem que estar nas subclasses
    protected BaseDesenhista artefinalizador;
    protected BaseDesenhista desenhista;
    protected BaseEscritor escritor;

    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public abstract void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException;

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public abstract void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException;

    public LocalDate getDataProducao() {
        return dataProducao;
    }

    public abstract void setDataProducao(LocalDate dataProducao) throws HistoriaInvalidaException;

    public BaseDesenhista getArtefinalizador() {
        return artefinalizador;
    }

    public abstract void setArtefinalizador(BaseDesenhista artefinalizador) throws HistoriaInvalidaException, DesenhistaInvalidoException;

    public BaseDesenhista getDesenhista() {
        return desenhista;
    }

    public abstract void setDesenhista(BaseDesenhista desenhista) throws DesenhistaInvalidoException;

    public BaseEscritor getEscritor() {
        return escritor;
    }

    public abstract void setEscritor(BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException;
}
