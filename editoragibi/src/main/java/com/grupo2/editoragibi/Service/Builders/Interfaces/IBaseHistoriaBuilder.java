package com.grupo2.editoragibi.Service.Builders.Interfaces;

import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.List;

public interface IBaseHistoriaBuilder {

    public void setHistoriaId(int historiaId);

    public void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException;

    public void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException;

    public void setDataProducao(LocalDate dataProducao) throws HistoriaInvalidaException;

    public void setArtefinalizador(int artefinalizadorId) throws DesenhistaInvalidoException, HistoriaInvalidaException;

    public void setDesenhista(int desenhistaId) throws DesenhistaInvalidoException;

    public void setEscritor(int escritorId) throws PersonagemInvalidoException, EscritorInvalidoException;

    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException;

    public BaseHistoria getResult();
}
