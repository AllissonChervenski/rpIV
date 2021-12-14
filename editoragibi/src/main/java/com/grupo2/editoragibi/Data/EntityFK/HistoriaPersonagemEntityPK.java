package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class HistoriaPersonagemEntityPK implements Serializable {
    private int historiaId;
    private int personagemId;

    @Column(name = "historia_id")
    @Id
    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
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

        HistoriaPersonagemEntityPK that = (HistoriaPersonagemEntityPK) o;

        if (historiaId != that.historiaId) return false;
        if (personagemId != that.personagemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = historiaId;
        result = 31 * result + personagemId;
        return result;
    }
}
