package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;

@Entity
@Table(name = "escritor_personagem", schema = "public", catalog = "sistemagibi")
@IdClass(EscritorPersonagemEntityPK.class)
public class EscritorPersonagemEntity {
    private int escritorId;
    private int personagemId;

    @Id
    @Column(name = "escritor_id")
    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    @Id
    @Column(name = "personagem_id")
    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EscritorPersonagemEntity that = (EscritorPersonagemEntity) o;

        if (escritorId != that.escritorId) return false;
        if (personagemId != that.personagemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = escritorId;
        result = 31 * result + personagemId;
        return result;
    }
}
