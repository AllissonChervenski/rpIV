package com.grupo2.editoragibi.Service.Builders.Interfaces;
<<<<<<< HEAD

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
=======
>>>>>>> 6937cbc26493729c8ae60d52cf58b297d1144655

import java.time.LocalDate;
import java.util.List;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

public interface IBaseGibiBuilder {

    public void setEncData(LocalDate encData);

    public void setGibi_id(Integer gibi_id);

    public void setInicioData(LocalDate inicioData);

    public void setTituloGibi(String tituloGibi) throws GibiInvalidoException;

    public void setEdicoesGibi(List<Integer> edicoesGibi) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException;

    public void setEdicaoGibi(BaseEdicoesGibi edicaoGibi);

    public void setEdicaoGibi(Integer edicaoGibi);

    public BaseGibi getResult();
}