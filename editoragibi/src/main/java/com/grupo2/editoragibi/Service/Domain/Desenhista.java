package com.grupo2.editoragibi.Service.Domain;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Desenhista extends BaseDesenhista {

    public void setNomeDesenhista(String nomeDesenhista) throws DesenhistaInvalidoException {
        if (nomeDesenhista == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,20}$", nomeDesenhista))
            throw new DesenhistaInvalidoException("Nome Inválido");
        this.nomeDesenhista = nomeDesenhista;
    }

    public void setPaisNascimento(String paisNascimento) throws DesenhistaInvalidoException {
        if (paisNascimento == null || !Pattern.matches("^[a-zA-Z\\s]([a-zA-Z])[a-zA-Z\\s]{1,20}$", paisNascimento))
            throw new DesenhistaInvalidoException("País inválido");
        this.paisNascimento = paisNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) throws DesenhistaInvalidoException {
        if (dataNascimento == null || !validDate(dataNascimento))
            throw new DesenhistaInvalidoException("Data inválida");
        this.dataNascimento = dataNascimento;
    }

    public void setDataFalecimento(LocalDate dataFalecimento) throws DesenhistaInvalidoException {
        if (dataFalecimento != null && !validDate(dataFalecimento))
            throw new DesenhistaInvalidoException("Data inválida");
        this.dataFalecimento = dataFalecimento;
    }

    private boolean validDate(LocalDate date) {
        if (date.isAfter(LocalDate.now()))
            return false;
        return true;
    }

    public void setEnderecoDesenhista(String enderecoDesenhista) throws DesenhistaInvalidoException {
        if (enderecoDesenhista == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,25}$", enderecoDesenhista))
            throw new DesenhistaInvalidoException("Endereco inválido");
        this.enderecoDesenhista = enderecoDesenhista;
    }

    public void setDataContratacao(LocalDate dataContratacao) throws DesenhistaInvalidoException {
        if (dataContratacao == null || !validDate(dataContratacao))
            throw new DesenhistaInvalidoException("Data inválida");
        this.dataContratacao = dataContratacao;
    }

    public void setDataDemissao(LocalDate dataDemissao) throws DesenhistaInvalidoException {
        if (dataDemissao != null && !validDate(dataDemissao))
            throw new DesenhistaInvalidoException("Data inválida");
        this.dataDemissao = dataDemissao;
    }
}
