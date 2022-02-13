package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.EscritorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEscritorRepository extends JpaRepository<EscritorEntity, Integer> {
}
