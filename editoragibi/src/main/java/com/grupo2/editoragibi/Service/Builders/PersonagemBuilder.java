package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBasePersonagemBuilder;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
import com.grupo2.editoragibi.Service.Directors.EscritorDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("personagemBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonagemBuilder implements IBasePersonagemBuilder {

    @Autowired
    EscritorRepository escritorRepository;

    @Lazy
    @Autowired
    EscritorDirector escritorDirector;


    private Personagem personagem;

    public PersonagemBuilder() {
        reset();
    }

    public void reset() {
        personagem = new Personagem();
    }

    @Override
    public void setPersonagemId(int id) {
        personagem.setPersonagemId(id);
    }

    @Override
    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
        try {
            personagem.setNomePersonagem(nomePersonagem);
        } catch (PersonagemInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setHistoriaPersonagem(String historiaPersonagem) {
        personagem.setHistoricoPersonagem(historiaPersonagem);
    }

    @Override
    public void setPatentePersonagem(String patentePersonagem) {
        personagem.setPatentePersonagem(patentePersonagem);
    }

    @Override
    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
        try {
            personagem.setDataCriacao(dataCriacao);
        } catch (PersonagemInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEscritores(List<Integer> escritoresIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<Escritor> personagensEscritor = personagem.getEscritores();
        for (Integer id : escritoresIds) {
            personagensEscritor.add((Escritor) escritorDirector.buildFromEscritorEntity(escritorRepository.getEscritorById(id), personagem));
        }
    }

    @Override
    public void setEscritor(BaseEscritor escritor) {
        if (escritor instanceof Escritor)
            personagem.getEscritores().add((Escritor) escritor);
    }

    @Override
    public BasePersonagem getResult() {
        Personagem toReturn = personagem;
        reset();
        return toReturn;
    }



 
}
