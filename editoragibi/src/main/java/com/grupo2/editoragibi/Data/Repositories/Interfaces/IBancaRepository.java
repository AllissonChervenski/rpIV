package com.grupo2.editoragibi.Data.Repositories.Interfaces;

import com.grupo2.editoragibi.Data.Entity.BancaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBancaRepository extends JpaRepository<BancaEntity, Integer> {
}
