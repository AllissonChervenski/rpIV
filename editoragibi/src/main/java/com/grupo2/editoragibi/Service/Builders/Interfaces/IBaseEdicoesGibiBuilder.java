package com.grupo2.editoragibi.Service.Builders.Interfaces;

import java.time.LocalDate;
import java.util.List;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
<<<<<<< HEAD
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
=======
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
import com.grupo2.editoragibi.editor.Editor;

public interface IBaseEdicoesGibiBuilder{

<<<<<<< HEAD
    public void setDataPub(LocalDate dataPub);
=======
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

   
    public void setEdicaoGibiId(int id);

<<<<<<< HEAD
    public void setEdicaoGibi_id(int edicaoGibi_id);

 
    public void setEditor(Editor editor);

  
    public void setGibi(GibiEntity gibi);

    public void setHistoriaEntity(List<HistoriaEntity> historiaEntity);


    public void setNroEdicao(int nroEdicao);
=======
    public void setEditor(Integer editorId);

  
    public void setGibi(Integer gibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException;

    public void setGibi(BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException;

    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException;

    public void setHistoria(Integer historiaId) throws HistoriaInvalidaException;

    public void setPersonagens(List<Integer> personagensId) throws PersonagemInvalidoException, EscritorInvalidoException;

    public void setPersonagem(BasePersonagem personagem);

    public void setPersonagem(Integer personagemId) throws PersonagemInvalidoException, EscritorInvalidoException;

    public void setDesenhistas(List<Integer> desenhistaId) throws DesenhistaInvalidoException;

    public void setDesenhista(BaseDesenhista desenhista);

    public void setDesenhista(Integer desenhistaId) throws DesenhistaInvalidoException;

    public void setEscritores(List<Integer> escritorId);

    public void setEscritor(BaseEscritor escritor);

    public void setEscritor(Integer escritorId) throws EscritorInvalidoException, PersonagemInvalidoException;

    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas);

    public void setPublicada(boolean publicada);


<<<<<<< HEAD
    public EdicoesGibi getResult();
=======
    public BaseEdicoesGibi getResult();
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
  
    
}
