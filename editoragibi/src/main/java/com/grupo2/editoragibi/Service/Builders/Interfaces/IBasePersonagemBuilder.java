package com.grupo2.editoragibi.Service.Builders.Interfaces;

<<<<<<< HEAD
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
=======
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
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

    public void setEscritor(BaseEscritor escritor);

<<<<<<< HEAD
=======
    public void setEdicaoGibi(BaseEdicoesGibi edicoes);
    
    public void setEdicoesGibi(List<Integer> edicoesId) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException;

>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    public BasePersonagem getResult();
}
