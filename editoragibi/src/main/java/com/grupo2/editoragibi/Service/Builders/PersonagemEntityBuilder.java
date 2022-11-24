package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
<<<<<<< HEAD
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBasePersonagemBuilder;
=======
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBasePersonagemBuilder;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component("personagemEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonagemEntityBuilder implements IBasePersonagemBuilder {

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    EdicoesGibiRepository edicoesGibiRepository;

    private PersonagemEntity personagemEntity;

    public PersonagemEntityBuilder() {
        reset();
    }

    public void reset() {
        personagemEntity = new PersonagemEntity();
    }

    @Override
    public void setPersonagemId(int id) {
        personagemEntity.setPersonagemId(id);
    }

    @Override
    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
        personagemEntity.setNomePersonagem(nomePersonagem);
    }

    @Override
    public void setHistoriaPersonagem(String historiaPersonagem) {
        personagemEntity.setHistoricoPersonagem(historiaPersonagem);
    }

    @Override
    public void setPatentePersonagem(String patentePersonagem) {
        personagemEntity.setPatentePersonagem(patentePersonagem);
    }

    @Override
    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
        personagemEntity.setDataCriacao(dataCriacao);
    }

    @Override
    public void setEscritores(List<Integer> escritoresIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<EscritorEntity> escritoresPersonagem = new ArrayList<>();
        if(escritoresIds != null){
        escritorRepository.getEscritores().forEach(e -> escritoresPersonagem.add(e));
        for (Integer id : escritoresIds) {
            escritoresPersonagem.add(escritorRepository.getEscritorById(id));
        }
    }
        
    }

    @Override
    public void setEscritor(BaseEscritor escritor) {
        if (escritor instanceof EscritorEntity)
            personagemEntity.getEscritores().add((EscritorEntity) escritor);
    }

    @Override
    public BasePersonagem getResult() {
        PersonagemEntity toReturn = personagemEntity;
        reset();
        return toReturn;
    }

    @Override
    public void setEdicaoGibi(BaseEdicoesGibi edicoes) {
        // TODO Auto-generated method stub
        if(edicoes instanceof EdicoesGibi){
            personagemEntity.getEdicoesGibi().add((EdicoesGibi) edicoes);
        }
        
    }

    @Override
    public void setEdicoesGibi(List<Integer> edicoesId)  {
        // TODO Auto-generated method stub
        List<EdicoesGibiEntity> edicoesPersonagens = new ArrayList<>();
        if(edicoesId != null){
       edicoesGibiRepository.getEdicoesGibis().forEach(e -> edicoesPersonagens.add(e));
        for (Integer id : edicoesId) {
            edicoesPersonagens.add(edicoesGibiRepository.getEdicaoGibiById(id).get());
        }
    }
    }

  
}
