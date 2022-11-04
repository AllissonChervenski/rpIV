package com.grupo2.editoragibi.Service.Builders.Interfaces;

import java.time.LocalDate;
import java.util.List;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.editor.Editor;

public interface IBaseEdicoesGibiBuilder{

    public void setDataPub(LocalDate dataPub);

   
    public void setEdicaoGibiId(int id);

    public void setEdicaoGibi_id(int edicaoGibi_id);

 
    public void setEditor(Editor editor);

  
    public void setGibi(GibiEntity gibi);

    public void setHistoriaEntity(List<HistoriaEntity> historiaEntity);


    public void setNroEdicao(int nroEdicao);

    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas);

    public void setPublicada(boolean publicada);


    public EdicoesGibi getResult();
  
    
}
