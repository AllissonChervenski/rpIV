package com.grupo2.editoragibi.Service.Builders.Interfaces;

import java.time.LocalDate;
import java.util.List;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import com.grupo2.editoragibi.editor.Editor;

public interface IBaseEdicoesGibiBuilder{

    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException;

   
    public void setEdicaoGibiId(int id);

    public void setEditor(Integer editorId);

  
    public void setGibi(Integer gibiId) throws GibiInvalidoException;

    public void setGibi(BaseGibi gibi) throws GibiInvalidoException;

    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException;

    public void setHistoria(Integer historiaId) throws HistoriaInvalidaException;

    public void setPersonagens(List<Integer> personagensId) throws PersonagemInvalidoException, EscritorInvalidoException;

    public void setPersonagem(BasePersonagem personagem);

    public void setPersonagem(Integer personagemId);

    public void setDesenhistas(List<Integer> desenhistaId);

    public void setDesenhista(BaseDesenhista desenhista);

    public void setDesenhista(Integer desenhistaId);

    public void setEscritores(List<Integer> escritorId);

    public void setEscritor(BaseEscritor escritor);

    public void setEscritor(Integer escritorId);

    public void setNroEdicao(int nroEdicao);

    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas);

    public void setPublicada(boolean publicada);


    public EdicoesGibi getResult();
  
    
}
