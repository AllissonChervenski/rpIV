package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;

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
        super.setEncData(encData);
    }

    @Override
    public void setInicioData(LocalDate inicioData) {
        // TODO Auto-generated method stub
        super.setInicioData(inicioData);
    }

    @Override
    public void setTituloGibi(String tituloGibi) {
        // TODO Auto-generated method stub
        super.setTituloGibi(tituloGibi);
    }
    
}
