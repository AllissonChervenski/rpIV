package com.grupo2.editoragibi.Service.Builders.Interfaces;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.List;

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
