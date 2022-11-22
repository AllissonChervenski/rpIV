package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;

public class EdicoesGibi extends BaseEdicoesGibi{

    List<Personagem> personagem = new ArrayList<>();
    List<Desenhista> desenhista = new ArrayList<>();
    List<Escritor> escritor = new ArrayList<>();


    public List<Personagem> getPersonagem() {
        return personagem;
    }

    public List<Desenhista> getDesenhista() {
        return desenhista;
    }

    public List<Escritor> getEscritor() {
        return escritor;
    }

    @Override
    public LocalDate getDataPub() {
        // TODO Auto-generated method stub
        return this.getDataPub();
    }

    @Override
    public int getEdicaoGibi_id() {
        // TODO Auto-generated method stub
        return this.getEdicaoGibi_id();
    }

    @Override
    public int getNroEdicao() {
        // TODO Auto-generated method stub
        return this.getNroEdicao();
    }

    @Override
    public boolean isPublicada() {
        // TODO Auto-generated method stub
        return this.isPublicada();
    }

    @Override
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        if(dataPub != null && validDate(dataPub) ){
            this.dataPub = dataPub;
    } 
        else{
            throw new EdicoesGibiInvalidoException("Data inválida");
        }
    }

    private boolean validDate(LocalDate date) {
        if (date.isAfter(LocalDate.now()))
            return false;
        return true;
    }

    @Override
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        this.edicaoGibi_id = edicaoGibi_id;
    }

    @Override
    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException {
        if(nroEdicao != 0  ){
            this.nroEdicao = nroEdicao;
        }
        else{
            throw new EdicoesGibiInvalidoException("Número da edição é inválido");
        }
    }

    @Override
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    @Override
    public void setGibi(BaseGibi gibi) throws GibiInvalidoException {
        if(gibi == null){
            throw new GibiInvalidoException("Informe um gibi válido"); 
        }
        this.gibi = gibi;
        
    }
    

    @Override
    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException {
        if(historia != null){
            this.historia = historia;
        }
        else{
            throw new HistoriaInvalidaException("Informe uma história válida");
        }
    }

    
}
