package com.grupo2.editoragibi.Api.Requests;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import lombok.Data;

import java.time.LocalDate;


@Data
public class EscritorRequest extends BaseEscritor {

    private List<Integer> personagensIds;

    @Override
    public void setNomeEscritor(String nomeEscritor) throws EscritorInvalidoException {
        this.nomeEscritor = nomeEscritor;
    }

    @Override
    public void setEnderecoEscritor(String enderecoEscritor) throws EscritorInvalidoException {
        this.enderecoEscritor = enderecoEscritor;
    }

    @Override
    public void setTelefoneEscritor(String telefoneEscritor) throws EscritorInvalidoException {
        this.telefoneEscritor = telefoneEscritor;
    }

    @Override
    public void setEmailEscritor(String emailEscritor) throws EscritorInvalidoException {
        this.emailEscritor = emailEscritor;
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) throws EscritorInvalidoException {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) throws EscritorInvalidoException {
        this.dataDemissao = dataDemissao;
    }


}
