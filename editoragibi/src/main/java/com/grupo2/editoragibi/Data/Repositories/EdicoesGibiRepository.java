
package com.grupo2.editoragibi.Data.Repositories;

<<<<<<< HEAD
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
=======
import com.grupo2.editoragibi.Api.Requests.EdicoesGibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
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
<<<<<<< HEAD
=======
    
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    public Optional<EdicoesGibiEntity> getEdicaoByNumero(int nroEdicao){
        Optional<EdicoesGibiEntity> edicoesGibiEntity = edicoesGibiRepository.findEdicoesGibiByEdicao(nroEdicao);
    
        return edicoesGibiEntity;
    }


    public List<EdicoesGibiEntity> getEdicoesGibis(){
       List<EdicoesGibiEntity> edicoesGibiEntityList = edicoesGibiRepository.findAll();
       return edicoesGibiEntityList;
       
    }

    public Optional<EdicoesGibiEntity> getEdicaoGibiById(int id){
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.findById(id);
        return eOptional;
    }

    public void deleteEdicoesGibisById(Integer id){
        edicoesGibiRepository.deleteById(id);
    }


<<<<<<< HEAD
    public void save(EdicoesGibiEntity edicoesGibiEntity){
        edicoesGibiRepository.save(edicoesGibiEntity);
=======
    public EdicoesGibiEntity save(EdicoesGibiEntity edicoesGibiEntity){
        return edicoesGibiRepository.save(edicoesGibiEntity);
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    }

}

