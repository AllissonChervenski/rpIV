package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

import java.time.LocalDate;

public class DesenhistaBuilder implements IBaseDesenhistaBuilder {

    private Desenhista desenhista;

    public DesenhistaBuilder() {
        reset();
    }

    private void reset() {
        desenhista = new Desenhista();
    }

    @Override
    public void setDesenhistaId(int id) {
        desenhista.setDesenhistaId(id);
    }

    @Override
    public void setNomeDesenhista(String nomeDesenhista) throws DesenhistaInvalidoException {
        try {
            desenhista.setNomeDesenhista(nomeDesenhista);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEnderecoDesenhista(String enderecoDesenhista) throws DesenhistaInvalidoException {
        try {
            desenhista.setEnderecoDesenhista(enderecoDesenhista);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setPaisNascimento(String paisNascimento) throws DesenhistaInvalidoException {
        try {
            desenhista.setPaisNascimento(paisNascimento);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) throws DesenhistaInvalidoException {
        try {
            desenhista.setDataNascimento(dataNascimento);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataFalecimento(LocalDate dataFalecimento) throws DesenhistaInvalidoException {
        try {
            desenhista.setDataFalecimento(dataFalecimento);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) throws DesenhistaInvalidoException {
        try {
            desenhista.setDataContratacao(dataContratacao);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) throws DesenhistaInvalidoException {
        try {
            desenhista.setDataDemissao(dataDemissao);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public BaseDesenhista getResult() {
        Desenhista toReturn = desenhista;
        reset();
        return toReturn;
    }
}
