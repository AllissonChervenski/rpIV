package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;

import java.time.LocalDate;

public interface IBaseDesenhistaBuilder {

    public void setDesenhistaId(int id);

    public void setNomeDesenhista(String nomeDesenhista) throws DesenhistaInvalidoException;

    public void setEnderecoDesenhista(String enderecoDesenhista) throws DesenhistaInvalidoException;

    public void setPaisNascimento(String paisNascimento) throws DesenhistaInvalidoException;

    public void setDataNascimento(LocalDate dataNascimento) throws DesenhistaInvalidoException;

    public void setDataFalecimento(LocalDate dataFalecimento) throws DesenhistaInvalidoException;

    public void setDataContratacao(LocalDate dataContratacao) throws DesenhistaInvalidoException;

    public void setDataDemissao(LocalDate dataDemissao) throws DesenhistaInvalidoException;

    public BaseDesenhista getResult();
}
