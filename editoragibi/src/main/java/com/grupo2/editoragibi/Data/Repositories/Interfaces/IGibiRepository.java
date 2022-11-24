package com.grupo2.editoragibi.Data.Repositories.Interfaces;



import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGibiRepository extends JpaRepository<GibiEntity, Long>{

    @Query("SELECT g FROM GibiEntity g WHERE g.tituloGibi = ?1")
    Optional<GibiEntity> findGibiByTitulo(String titulo);

    @Query("SELECT e FROM EdicoesGibiEntity e WHERE e.edicaoGibi_id = ?1")
    Optional<EdicoesGibiEntity> findEdicaoGibiById(Long id);
}
