package com.editoragibi.editoragibi.Data;

import com.editoragibi.editoragibi.Data.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, String> {
}
