package com.grupo2.editoragibi.Data.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario_role")
public class UsuarioRoleEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "user_name")
    private String userName;

    @Id
    @Column(name = "role_id")
    private int roleId;
}
