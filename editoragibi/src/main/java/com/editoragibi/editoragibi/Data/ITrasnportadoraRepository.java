package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.TransportadoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrasnportadoraRepository extends JpaRepository<TransportadoraEntity, Integer> {
}
