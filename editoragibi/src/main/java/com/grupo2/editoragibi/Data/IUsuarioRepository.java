package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, String> {
}
