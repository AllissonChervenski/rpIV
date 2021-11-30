package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGibiRepository extends JpaRepository<GibiEntity, Integer> {
    
}
