
package com.grupo2.editoragibi.Data.Repositories;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EdicoesGibiRepository{

    @Autowired
    IEdicoesGibiRepository edicoesGibiRepository;
    //@Query("SELECT e FROM BaseEdicoesGibi e WHERE e.nroEdicao = ?1 ")
    
    public EdicoesGibiEntity getEdicaoByNumero(int nroEdicao) throws EdicoesGibiInvalidoException{
        Optional<EdicoesGibiEntity> edicoesGibiEntity = edicoesGibiRepository.findEdicoesGibiByEdicao(nroEdicao);
        if(edicoesGibiEntity.isEmpty()){
            throw new EdicoesGibiInvalidoException("Esta edição não existe");
        }
        return edicoesGibiEntity.get();
    }

    public List<EdicoesGibiEntity> getEdicoesGibis(){
        return edicoesGibiRepository.findAll();
    }

    public void deleteEdicoesGibisById(Integer id){
        edicoesGibiRepository.deleteById(id);
    }



}

