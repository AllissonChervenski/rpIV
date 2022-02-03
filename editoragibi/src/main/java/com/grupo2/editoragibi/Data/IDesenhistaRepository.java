package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDesenhistaRepository extends JpaRepository<DesenhistaEntity, Integer> {

}
