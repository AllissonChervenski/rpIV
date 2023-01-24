package com.grupo2.editoragibi.Data.Repositories.Interfaces;



import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Domain.Gibi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IGibiRepository extends JpaRepository<GibiEntity, Integer>{

    @Query("SELECT g FROM GibiEntity g WHERE g.tituloGibi = :titulo")
    GibiEntity findByTitulo(@Param("titulo") String titulo);
}
