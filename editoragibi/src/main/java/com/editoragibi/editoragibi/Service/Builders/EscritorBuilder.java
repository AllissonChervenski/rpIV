package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Data.PersonagemRepository;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseEscritor;
import com.editoragibi.editoragibi.Service.BaseObjects.BasePersonagem;
import com.editoragibi.editoragibi.Service.Directors.PersonagemDirector;
import com.editoragibi.editoragibi.Service.Domain.Escritor;
import com.editoragibi.editoragibi.Service.Domain.Personagem;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("escritorBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EscritorBuilder implements IBaseEscritorBuilder {

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    PersonagemDirector personagemDirector;

    private Escritor escritor;

    public EscritorBuilder() {
        reset();
    }

    private void reset() {
        escritor = new Escritor();
    }

    @Override
    public void setEscritorId(int id) {
        escritor.setEscritorId(id);
    }

    @Override
    public void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException {
        try {
            escritor.setNomeEscritor(nomeEscritor);
        } catch (EscritorInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException {
        try {
            escritor.setEnderecoEscritor(enderecoEscritor);
        } catch (EscritorInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException {
        try {
            escritor.setTelefoneEscritor(telefoneEscritor);
        } catch (EscritorInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException {
        try {
            escritor.setEmailEscritor(emailEscritor);
        } catch (EscritorInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) {
        escritor.setDataContratacao(dataContratacao);
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) {
        escritor.setDataDemissao(dataDemissao);
    }

    @Override
    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<Personagem> personagensEscritor = escritor.getPersonagens();
        for (Integer id : personagensIds) {
            personagensEscritor.add((Personagem) personagemDirector.buildFromPersonagemEntity(personagemRepository.getPersonagemById(id), escritor));
        }
    }

    @Override
    public void setPersonagem(BasePersonagem personagem) {
        if (personagem instanceof Personagem)
            escritor.getPersonagens().add((Personagem) personagem);
    }

    @Override
    public BaseEscritor getResult() {
        Escritor toReturn = escritor;
        reset();
        return toReturn;
    }
}
