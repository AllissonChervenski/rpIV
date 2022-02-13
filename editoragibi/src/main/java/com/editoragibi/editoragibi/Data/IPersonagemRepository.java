package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.PersonagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonagemRepository extends JpaRepository<PersonagemEntity, Integer> {
}
