package com.grupo2.editoragibi.Service.Builders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import com.grupo2.editoragibi.Service.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.Repositories.DesenhistaRepository;
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.Repositories.DesenhistaRepository;
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
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

    @Autowired
    private GibiRepository gibi;

    @Autowired
    private HistoriaRepository historia;

    @Autowired
    private PersonagemRepository personagem;

    @Autowired
    private DesenhistaRepository desenhista;

    @Autowired
    private EscritorRepository escritor;

    public EdicoesGibiEntityBuilder(){
        reset();
    }

    private void reset(){
        edicoesGibiEntity = new EdicoesGibiEntity(); 
    }

    @Override
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        edicoesGibiEntity.setDataPub(dataPub);
        
    }

    @Override
    public void setEdicaoGibiId(int id) {
        edicoesGibiEntity.setEdicaoGibi_id(id);;
        
    }

    @Override
    public void setEditor(Integer editorId) {
        //
        //
    }

    @Override
    public void setGibi(Integer gibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        edicoesGibiEntity.setGibi(gibi.getGibiById(gibiId).get());
        
    }

    @Override
    public void setGibi(Gibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        edicoesGibiEntity.setGibi(gibi);
        
    }

    @Override
    public void setHistoria(Historia historia) throws HistoriaInvalidaException {
        edicoesGibiEntity.setHistoria(historia);
        edicoesGibiEntity.setHistoria(historia);
    }

    @Override
    public void setHistoria(Integer historiaId) throws HistoriaInvalidaException {
        edicoesGibiEntity.setHistoria(historia.getHistoriaById(historiaId));
        
    }

    @Override
    public void setPersonagens(List<Integer> personagensId) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<PersonagemEntity> personagensEdicoes = new ArrayList<>();
        if(personagensId != null){
            personagem.getPersonagens().forEach(e -> personagensEdicoes.add(e));
            try{
                for(Integer i : personagensId){
                personagensEdicoes.add(personagem.getPersonagemById(i));
            edicoesGibiEntity.setPersonagem(personagem.getPersonagemById(i));
        }
    }
        catch(PersonagemInvalidoException | EscritorInvalidoException p){
            p.getCause();
        }
    }
    }
    

    @Override
    public void setPersonagem(Personagem personagem) {
        edicoesGibiEntity.setPersonagem(personagem);
        edicoesGibiEntity.setPersonagem(personagem);
    }

    @Override
    public void setPersonagem(Integer personagemId) {
        try {
            edicoesGibiEntity.setPersonagem(personagem.getPersonagemById(personagemId));
        } catch (PersonagemInvalidoException | EscritorInvalidoException e) {
            e.getCause();
        }
        try {
            edicoesGibiEntity.setPersonagem(personagem.getPersonagemById(personagemId));
        } catch (PersonagemInvalidoException | EscritorInvalidoException e) {
            e.getCause();
        }
    }

    @Override
    public void setDesenhistas(List<Integer> desenhistaId) throws DesenhistaInvalidoException {
        List<DesenhistaEntity> desenhistaEdicoes = new ArrayList<>();
       if(desenhistaId != null){
        desenhista.getDesenhistas().forEach(d -> desenhistaEdicoes.add(d));
        for(Integer i : desenhistaId){
            try {
               desenhistaEdicoes.add(desenhista.getDesenhistaById(i));
            } catch (DesenhistaInvalidoException e) {
                e.getCause();
            }
        }
    }
}


    @Override
    public void setDesenhista(Desenhista desenhista) {
        edicoesGibiEntity.setDesenhista(desenhista);
        
    }

    @Override
    public void setDesenhista(Integer desenhistaId) {
        try {
            edicoesGibiEntity.setDesenhista(desenhista.getDesenhistaById(desenhistaId));
        } catch (DesenhistaInvalidoException e) {
            e.getCause();
        }
        
    }

    @Override
    public void setEscritores(List<Integer> escritorId) throws EscritorInvalidoException, PersonagemInvalidoException {
        List<EscritorEntity> escritorEdicoes = new ArrayList<>();
        if(escritorId != null){
        for(Integer i:escritorId){
            escritorEdicoes.add(escritor.getEscritorById(i));
            try {
                edicoesGibiEntity.setEscritor(escritor.getEscritorById(i));
            } catch (EscritorInvalidoException | PersonagemInvalidoException e) {
                e.getCause();
            }
        }
    }
        
    }

    @Override
    public void setEscritor(Escritor escritor) {
      edicoesGibiEntity.setEscritor(escritor);
        
    }

    @Override
    public void setEscritor(Integer escritorId) {
        try {
            edicoesGibiEntity.setEscritor(escritor.getEscritorById(escritorId));
        } catch (EscritorInvalidoException | PersonagemInvalidoException e) {
            e.getCause();
        }
        
    }

    @Override
    public void setNroEdicao(int nroEdicao) {
        edicoesGibiEntity.setNroEdicao(nroEdicao);
        edicoesGibiEntity.setNroEdicao(nroEdicao);
    }

    @Override
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        edicoesGibiEntity.setNumeroExemplaresImpressas(numeroExemplaresImpressas);
        
    }

    @Override
    public void setPublicada(boolean publicada) {
        edicoesGibiEntity.setPublicada(publicada);        
    }

    @Override
    public BaseEdicoesGibi getResult() {
      EdicoesGibiEntity toReturn = edicoesGibiEntity;
      edicoesGibiEntity = new EdicoesGibiEntity();
      return toReturn;
    }



}