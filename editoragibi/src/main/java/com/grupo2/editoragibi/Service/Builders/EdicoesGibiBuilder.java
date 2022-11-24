package com.grupo2.editoragibi.Service.Builders;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEdicoesGibiBuilder;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.editor.Editor;

@Component("edicoesGibiBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EdicoesGibiBuilder implements IBaseEdicoesGibiBuilder {

    private EdicoesGibiEntity edicoesGibiEntity;

    public EdicoesGibiBuilder(){
        reset();
    }

    public void reset(){
        edicoesGibiEntity = new EdicoesGibiEntity();
    }

    @Override
    public void setDataPub(LocalDate dataPub) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setDataPub(dataPub);
    }

    @Override
    public void setEdicaoGibiId(int id) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setEdicaoGibiId(id);
    }

    @Override
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setEdicaoGibi_id(edicaoGibi_id);
    }

    @Override
    public void setEditor(Editor editor) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setEditor(editor);
    }

    @Override
    public void setGibi(GibiEntity gibi) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setGibi(gibi);
        
    }

    @Override
    public void setHistoriaEntity(List<HistoriaEntity> historiaEntity) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setHistoriaEntity(historiaEntity);
    }

    @Override
    public void setNroEdicao(int nroEdicao) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setNroEdicao(nroEdicao);
    }

    @Override
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setNroEdicao(numeroExemplaresImpressas);
    }

    @Override
    public void setPublicada(boolean publicada) {
        // TODO Auto-generated method stub
        edicoesGibiEntity.setPublicada(publicada);
    }

    @Override
    public EdicoesGibi getResult() {
        // TODO Auto-generated method stub
        EdicoesGibiEntity toReturn = edicoesGibiEntity;
        edicoesGibiEntity = new EdicoesGibiEntity();
        return toReturn;
    }
    
}
