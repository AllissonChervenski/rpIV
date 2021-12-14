package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EscritorPersonagemEntityPK implements Serializable {
    private int escritorId;
    private int personagemId;

    @Column(name = "escritor_id")
    @Id
    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    @Column(name = "personagem_id")
    @Id
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

        EscritorPersonagemEntityPK that = (EscritorPersonagemEntityPK) o;

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
