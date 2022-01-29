package com.grupo2.editoragibi.Data.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }

}
