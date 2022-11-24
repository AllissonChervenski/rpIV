package com.grupo2.editoragibi.Data.Repositories.Interfaces;



import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
<<<<<<< HEAD
public interface IGibiRepository extends JpaRepository<GibiEntity, Long>{
=======
public interface IGibiRepository extends JpaRepository<GibiEntity, Integer>{
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

    @Query("SELECT g FROM GibiEntity g WHERE g.tituloGibi = ?1")
    Optional<GibiEntity> findGibiByTitulo(String titulo);

    @Query("SELECT e FROM EdicoesGibiEntity e WHERE e.edicaoGibi_id = ?1")
<<<<<<< HEAD
    Optional<EdicoesGibiEntity> findEdicaoGibiById(Long id);
=======
    Optional<EdicoesGibiEntity> findEdicaoGibiById(Integer id);

>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
}
