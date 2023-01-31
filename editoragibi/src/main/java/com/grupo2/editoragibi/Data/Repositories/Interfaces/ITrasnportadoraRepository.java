package com.grupo2.editoragibi.Data.Repositories.Interfaces;

import com.grupo2.editoragibi.Data.Entity.TransportadoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrasnportadoraRepository extends JpaRepository<TransportadoraEntity, Integer> {
}
