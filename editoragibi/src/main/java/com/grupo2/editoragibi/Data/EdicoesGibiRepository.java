
package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EdicoesGibiRepository  extends JpaRepository<EdicoesGibiEntity, Long> {

    @Query("SELECT e FROM EdicoesGibi e WHERE e.nroEdicao = ?1 ")
    Optional<EdicoesGibiEntity> findEdicoesGibiByEdicao(Integer edicao);


}

