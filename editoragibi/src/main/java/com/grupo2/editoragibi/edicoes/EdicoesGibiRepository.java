
package com.grupo2.editoragibi.edicoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EdicoesGibiRepository  extends JpaRepository<EdicoesGibi, Long> {

    @Query("SELECT e FROM EdicoesGibi e WHERE e.nroEdicao = ?1 ")
    Optional<EdicoesGibi> findEdicoesGibiByEdicao(Integer edicao);


}

