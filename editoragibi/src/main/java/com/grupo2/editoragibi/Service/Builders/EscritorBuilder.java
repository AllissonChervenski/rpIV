package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.HistoriaRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EscritorBuilder implements IBaseEscritorBuilder {

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    HistoriaRepository historiaRepository;

    @Autowired
    ModelMapper modelMapper;

    private Escritor escritor;

    public EscritorBuilder() {
        reset();
    }

    private void reset() {
        escritor = new Escritor(personagemRepository);
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
    public void setPersonagens(List<BasePersonagem> personagens) throws PersonagemInvalidoException {
        List<Personagem> personagensEscritor = escritor.getPersonagens();
        for (BasePersonagem personagem : personagens) {
            personagensEscritor.add(modelMapper.map(personagem, Personagem.class));
        }
    }

    @Override
    public BaseEscritor getResult() {
        Escritor toReturn = escritor;
        reset();
        return toReturn;
    }
}
