package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.BancaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBancaRepository extends JpaRepository<BancaEntity, Integer> {
}
