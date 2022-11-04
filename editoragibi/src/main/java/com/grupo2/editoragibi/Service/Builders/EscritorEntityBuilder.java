package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.Repositories.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEscritorBuilder;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("escritorEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EscritorEntityBuilder implements IBaseEscritorBuilder {

    @Autowired
    PersonagemRepository personagemRepository;

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
    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<PersonagemEntity> personagensEscritor = escritorEntity.getPersonagens();
        for (Integer id : personagensIds) {
            personagensEscritor.add(personagemRepository.getPersonagemById(id));
        }
    }

    @Override
    public void setPersonagem(BasePersonagem personagem) {
        if (personagem instanceof PersonagemEntity)
            escritorEntity.getPersonagens().add((PersonagemEntity) personagem);
    }

    @Override
    public BaseEscritor getResult() {
        EscritorEntity toReturn = escritorEntity;
        escritorEntity = new EscritorEntity();
        return toReturn;
    }
}
