package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.IPersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EscritorEntityBuilder implements IBaseEscritorBuilder {

    @Autowired
    IPersonagemRepository iPersonagemRepository;

    @Autowired
    ModelMapper modelMapper;

    private EscritorEntity escritorEntity;

    public EscritorEntityBuilder() {
        reset();
    }

    private void reset() {
        escritorEntity = new EscritorEntity();
    }

    @Override
    public void setEscritorId(int id) {
        escritorEntity.setEscritorId(id);
    }

    @Override
    public void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException {
        escritorEntity.setNomeEscritor(nomeEscritor);
    }

    @Override
    public void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException {
        escritorEntity.setEnderecoEscritor(enderecoEscritor);
    }

    @Override
    public void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException {
        escritorEntity.setTelefoneEscritor(telefoneEscritor);
    }

    @Override
    public void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException {
        escritorEntity.setEmailEscritor(emailEscritor);
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) {
        escritorEntity.setDataContratacao(dataContratacao);
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) {
        escritorEntity.setDataDemissao(dataDemissao);
    }

    @Override
    public void setPersonagens(List<BasePersonagem> personagens) throws PersonagemInvalidoException {
        List<PersonagemEntity> personagensEscritor = escritorEntity.getPersonagens();
        for (BasePersonagem personagem : personagens) {
            personagensEscritor.add(modelMapper.map(personagem, PersonagemEntity.class));
        }
    }

    @Override
    public BaseEscritor getResult() {
        EscritorEntity toReturn = escritorEntity;
        escritorEntity = new EscritorEntity();
        return toReturn;
    }
}
