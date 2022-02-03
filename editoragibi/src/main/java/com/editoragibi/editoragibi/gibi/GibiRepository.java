package com.editoragibi.editoragibi.gibi;

import com.editoragibi.editoragibi.edicoes.EdicoesGibi;
import com.editoragibi.editoragibi.edicoes.EdicoesGibiRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GibiRepository extends JpaRepository<Gibi, Long>{

    @Query("SELECT g FROM Gibi g WHERE g.titulo = ?1")
    Optional<Gibi> findGibiByTitulo(String titulo);

    @Query("SELECT e FROM EdicoesGibi e WHERE e.edicaoGibiId = ?1")
    Optional<EdicoesGibi> findEdicaoGibiById(Long id);
}