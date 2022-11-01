package com.grupo2.editoragibi.Data.Repositories;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoriaRepository extends JpaRepository<HistoriaEntity, Integer> {
}
