package com.grupo2.editoragibi.Service.Builders.Interfaces;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.List;

public interface IBaseEscritorBuilder {

    public void setEscritorId(int id);

    public void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException;

    public void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException;

    public void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException;

    public void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException;

    public void setDataContratacao(LocalDate dataContratacao);

    public void setDataDemissao(LocalDate dataDemissao);

    public void setDataNascimentoEs(LocalDate dataNascimentoEs);

    public void setDataFalecimentoEs(LocalDate dataFalecimentoEs);

    public void setPaisNascimentoEs(String paisNascimentoEs);



    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException;

    public void setPersonagem(BasePersonagem personagem);

    public BaseEscritor getResult();
}
