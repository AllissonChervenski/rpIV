package com.grupo2.editoragibi.Data.Repositories.Interfaces;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;

@Repository
public interface IEdicoesGibiRepository  extends JpaRepository<EdicoesGibiEntity, Integer> {

    @Query("SELECT e FROM EdicoesGibiEntity e WHERE e.nroEdicao = ?1 ")
    Optional<EdicoesGibiEntity> findEdicoesGibiByEdicao(Integer edicao);


}