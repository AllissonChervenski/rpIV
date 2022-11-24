package com.grupo2.editoragibi.Service.BaseObjects;

import java.time.LocalDate;

<<<<<<< HEAD
public class BaseEdicoesGibi {
=======
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;

public abstract class BaseEdicoesGibi {

>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    protected int edicaoGibi_id;
    protected int nroEdicao;
    protected LocalDate dataPub;
    protected boolean publicada;
    protected int numeroExemplaresImpressas;
    
<<<<<<< HEAD
=======
    protected BaseGibi gibi;
    protected BaseHistoria historia;
    protected BaseEditora editora;

    public BaseEditora getEditora() {
        return editora;
    }
    public void setEditora(BaseEditora editora) {
        this.editora = editora;
    }
    
    public int getNumeroExemplaresImpressas() {
        return numeroExemplaresImpressas;
    }
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        this.numeroExemplaresImpressas = numeroExemplaresImpressas;
    }
    public BaseGibi getGibi() {
        return gibi;
    }
    public abstract void setGibi(BaseGibi gibi) throws EdicoesGibiInvalidoException, GibiInvalidoException;

    public BaseHistoria getHistoria() {
        return historia;
    }
    public abstract void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException;
 
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    public int getEdicaoGibi_id() {
        return edicaoGibi_id;
    }
    public void setEdicaoGibi_id(int edicaoGibi_id) {
        this.edicaoGibi_id = edicaoGibi_id;
    }
    public int getNroEdicao() {
        return nroEdicao;
    }
    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException {
        this.nroEdicao = nroEdicao;
    }
    public LocalDate getDataPub() {
        return dataPub;
    }
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException {
        this.dataPub = dataPub;
    }
    public boolean isPublicada() {
        return publicada;
    }
    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    
}
