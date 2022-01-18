package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.IPersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PersonagemEntityBuilder implements IBasePersonagemBuilder {

    @Autowired
    IPersonagemRepository iPersonagemRepository;

    @Autowired
    ModelMapper modelMapper;

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
    public void setEscritores(List<BaseEscritor> escritores) throws PersonagemInvalidoException {
        List<EscritorEntity> escritoresPersonagem = personagemEntity.getEscritores();
        for (BaseEscritor escritor : escritores) {
            escritoresPersonagem.add(modelMapper.map(escritor, EscritorEntity.class));
        }
    }

    @Override
    public BasePersonagem getResult() {
        return null;
    }
}
