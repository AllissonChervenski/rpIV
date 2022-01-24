package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PersonagemBuilder implements IBasePersonagemBuilder {

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    EscritorRepository escritorRepository;

    private Personagem personagem;

    public PersonagemBuilder() {
        reset();
    }

    public void reset() {
        personagem = new Personagem(personagemRepository);
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
            personagensEscritor.add(escritorRepository.getEscritorById(id));
        }
    }

    @Override
    public BasePersonagem getResult() {
        Personagem toReturn = personagem;
        reset();
        return toReturn;
    }
}
