package com.grupo2.editoragibi.Api.Requests;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

import java.time.LocalDate;

public class DesenhistaRequest extends BaseDesenhista {
    @Override
    public void setNomeDesenhista(String nomeDesenhista) throws DesenhistaInvalidoException {
        this.nomeDesenhista = nomeDesenhista;
    }

    @Override
    public void setPaisNascimento(String paisNascimento) throws DesenhistaInvalidoException {
        this.paisNascimento = paisNascimento;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) throws DesenhistaInvalidoException {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public void setDataFalecimento(LocalDate dataFalecimento) throws DesenhistaInvalidoException {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public void setEnderecoDesenhista(String enderecoDesenhista) throws DesenhistaInvalidoException {
        this.enderecoDesenhista = enderecoDesenhista;
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) throws DesenhistaInvalidoException {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) throws DesenhistaInvalidoException {
        this.dataDemissao = dataDemissao;
    }
}
