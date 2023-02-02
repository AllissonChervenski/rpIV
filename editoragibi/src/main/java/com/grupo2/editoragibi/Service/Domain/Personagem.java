package com.grupo2.editoragibi.Service.Domain;

import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Personagem extends BasePersonagem {

    @JsonManagedReference
    private List<Escritor> escritores = new ArrayList<>();

    private List<EdicoesGibi> edicoesGibis = new ArrayList<>();

    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
//        if (nomePersonagem == null || nomePersonagem.isEmpty())
//            throw new PersonagemInvalidoException("Nome inválido");
        this.nomePersonagem = nomePersonagem;
    }

    public void setHistoricoPersonagem(String historicoPersonagem) {
        this.historicoPersonagem = historicoPersonagem;
    }

    public void setPatentePersonagem(String patentePersonagem) {
        this.patentePersonagem = patentePersonagem;
    }

    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
//        if (dataCriacao.isAfter(LocalDate.now()))
//            throw new PersonagemInvalidoException("Data inválida");
        this.dataCriacao = dataCriacao;
    }

   public List<Escritor> getEscritores() {
        return this.escritores;
    }
    
    public List<EdicoesGibi> getEdicoesGibi(){
        return this.edicoesGibis;
    }
}
