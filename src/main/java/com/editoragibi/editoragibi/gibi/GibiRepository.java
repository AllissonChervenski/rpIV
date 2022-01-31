package com.editoragibi.editoragibi.gibi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GibiRepository extends JpaRepository<Gibi, Long>{

    @Query("SELECT g FROM Gibi g WHERE g.titulo = ?1")
    Optional<Gibi> findGibiByTitulo(String titulo);


}
