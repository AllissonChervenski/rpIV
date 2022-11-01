package com.grupo2.editoragibi.Data.Repositories.Interfaces;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEscritorRepository extends JpaRepository<EscritorEntity, Integer> {
}
