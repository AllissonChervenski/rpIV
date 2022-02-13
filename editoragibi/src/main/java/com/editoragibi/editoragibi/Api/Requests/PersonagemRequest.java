package com.editoragibi.editoragibi.Api.Requests;

import com.editoragibi.editoragibi.Service.BaseObjects.BasePersonagem;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonagemRequest extends BasePersonagem {

    private List<Integer> escritoresIds;

    @Override
    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
        this.nomePersonagem = nomePersonagem;
    }

    @Override
    public void setHistoricoPersonagem(String historicoPersonagem) {
        this.historicoPersonagem = historicoPersonagem;
    }

    @Override
    public void setPatentePersonagem(String patentePersonagem) {
        this.patentePersonagem = patentePersonagem;
    }

    @Override
    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
        this.dataCriacao = dataCriacao;
    }
}
