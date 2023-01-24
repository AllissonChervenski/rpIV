package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
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
        this.nroEdicao = nroEdicao;

    }

    @Override
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    @Override
    public void setGibi(BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        this.gibi = gibi;

    }


    @Override
    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException {
        this.historia = historia;

    }

    public void setEditor(EscritorEntity escritorById) {

    }

    public void setPersonagem(BasePersonagem personagem2) {
        this.personagem.add((Personagem) personagem2);
    }

    public void setDesenhista(BaseDesenhista desenhista2) {
        this.desenhista.add((Desenhista) desenhista2);
    }

    public void setEscritor(BaseEscritor escritor2) {
        this.escritor.add((Escritor) escritor2);
    }


}
