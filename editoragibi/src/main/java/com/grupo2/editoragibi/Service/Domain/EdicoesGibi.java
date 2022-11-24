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
<<<<<<< HEAD
    public int getEdicaoGibi_id() {
        // TODO Auto-generated method stub
        return super.getEdicaoGibi_id();
    }

    @Override
    public int getNroEdicao() {
        // TODO Auto-generated method stub
        return super.getNroEdicao();
    }

    @Override
    public boolean isPublicada() {
        // TODO Auto-generated method stub
        return super.isPublicada();
    }

    @Override
    public void setDataPub(LocalDate dataPub) {
        // TODO Auto-generated method stub
        super.setDataPub(dataPub);
    }

    @Override
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        // TODO Auto-generated method stub
        super.setEdicaoGibi_id(edicaoGibi_id);
    }

    @Override
    public void setNroEdicao(int nroEdicao) {
        // TODO Auto-generated method stub
        super.setNroEdicao(nroEdicao);
=======
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
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    }

    @Override
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    @Override
    public void setGibi(BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException {
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
