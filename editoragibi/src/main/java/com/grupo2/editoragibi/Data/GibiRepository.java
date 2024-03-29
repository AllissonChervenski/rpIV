package com.grupo2.editoragibi.Data;



import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GibiRepository extends JpaRepository<GibiEntity, Long>{

    @Query("SELECT g FROM Gibi g WHERE g.titulo = ?1")
    Optional<GibiEntity> findGibiByTitulo(String titulo);

    @Query("SELECT e FROM EdicoesGibi e WHERE e.edicaoGibiId = ?1")
    Optional<EdicoesGibiEntity> findEdicaoGibiById(Long id);
}
