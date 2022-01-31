package com.grupo2.editoragibi.Api.Requests;

import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
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
