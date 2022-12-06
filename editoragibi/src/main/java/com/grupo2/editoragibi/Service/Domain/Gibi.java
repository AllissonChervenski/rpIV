package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;

//Implement builder > Data Encerramento: Tem ou Nao | Data Inicio: Tem ou Nao | Data inicio: Tem ou Nao | Titutlo tem
//Tem ao menos uma edicao: Sim ou Nao | Descontinuado: Sim ou Nao 
public class Gibi extends BaseGibi {
    
    List<EdicoesGibi> edicoesGibi = new ArrayList<>();
    

    public List<EdicoesGibi> getEdicoesGibi() {
        return edicoesGibi;
    }

    @Override
    public void setEncData(LocalDate encData) {
        // TODO Auto-generated method stub
        if(encData != null && encData != LocalDate.now()){
            this.encData = encData;
        }
    }

    @Override
    public void setInicioData(LocalDate inicioData) {
        // TODO Auto-generated method stub
        if(inicioData != null){
            this.inicioData = inicioData;
        }
    }

    @Override
    public void setTituloGibi(String tituloGibi) throws GibiInvalidoException {
        if(tituloGibi != null && Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,100}$", tituloGibi)){
            this.tituloGibi = tituloGibi;
        }
        else{
            throw new GibiInvalidoException("Titulo inválido");
        }
        
    }


    public void setEdicaoGibi(BaseEdicoesGibi edicaoGibi){
        this.edicoesGibi.add((EdicoesGibi) edicaoGibi);
    }

    public void setEdicoesGibi(ArrayList<EdicoesGibi> edicoesGibi) {
        this.edicoesGibi = edicoesGibi;
    }
}
