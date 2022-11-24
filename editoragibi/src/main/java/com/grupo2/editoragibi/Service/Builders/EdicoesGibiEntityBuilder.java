package com.grupo2.editoragibi.Service.Builders;

<<<<<<< HEAD
public class EdicoesGibiEntityBuilder {
    
}
=======
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Repositories.GibiRepository;
import com.grupo2.editoragibi.Data.Repositories.HistoriaRepository;
import com.grupo2.editoragibi.Data.Repositories.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEdicoesGibiBuilder;
import com.grupo2.editoragibi.Service.Directors.PersonagemDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

@Component("edicoesGibiEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EdicoesGibiEntityBuilder implements IBaseEdicoesGibiBuilder {

    
    private EdicoesGibiEntity edicoesGibiEntity;

    @Override
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEdicaoGibiId(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEditor(Integer editorId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setGibi(Integer gibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setGibi(BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setHistoria(Integer historiaId) throws HistoriaInvalidaException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPersonagens(List<Integer> personagensId)
            throws PersonagemInvalidoException, EscritorInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPersonagem(BasePersonagem personagem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPersonagem(Integer personagemId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDesenhistas(List<Integer> desenhistaId) throws DesenhistaInvalidoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDesenhista(Integer desenhistaId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEscritores(List<Integer> escritorId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEscritor(BaseEscritor escritor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEscritor(Integer escritorId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setNroEdicao(int nroEdicao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPublicada(boolean publicada) {
        // TODO Auto-generated method stub
        
    }

    public EdicoesGibiEntityBuilder(){
        reset();
    }

    private void reset(){
        edicoesGibiEntity = new EdicoesGibiEntity();
    }
    
    @Override
    public BaseEdicoesGibi getResult() {
        // TODO Auto-generated method stub
      EdicoesGibiEntity toReturn = edicoesGibiEntity;
      edicoesGibiEntity = new EdicoesGibiEntity();
      return toReturn;
    }
  


}


>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
