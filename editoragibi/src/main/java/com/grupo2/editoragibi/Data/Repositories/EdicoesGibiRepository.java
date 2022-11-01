
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
    
    public boolean existsEdicaoGibi(int id){
        return edicoesGibiRepository.existsById(id);
    }
    public EdicoesGibiEntity getEdicaoByNumero(int nroEdicao) throws EdicoesGibiInvalidoException{
        Optional<EdicoesGibiEntity> edicoesGibiEntity = edicoesGibiRepository.findEdicoesGibiByEdicao(nroEdicao);
        if(edicoesGibiEntity.isEmpty()){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        return edicoesGibiEntity.get();
    }


    public List<EdicoesGibiEntity> getEdicoesGibis() throws EdicoesGibiInvalidoException{
       List<EdicoesGibiEntity> edicoesGibiEntityList = edicoesGibiRepository.findAll();
       if(edicoesGibiEntityList.isEmpty()){
        throw new EdicoesGibiInvalidoException("Nenhuma edição foi encontrada");
       }
       return edicoesGibiEntityList;
    }

    public EdicoesGibiEntity getEdicaoGibiById(int id) throws EdicoesGibiInvalidoException{
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.findById(id);
        if(eOptional.isEmpty()){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        return eOptional.get();
    }

    public void deleteEdicoesGibisById(Integer id) throws EdicoesGibiInvalidoException{
        if(edicoesGibiRepository.getById(id).equals(null)){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        edicoesGibiRepository.deleteById(id);
    }


    public void save(EdicoesGibiEntity edicoesGibiEntity){
        edicoesGibiRepository.save(edicoesGibiEntity);
    }

}

