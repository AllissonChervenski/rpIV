package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;

@Entity
@Table(name = "historia_personagem", schema = "public", catalog = "sistemagibi")
@IdClass(HistoriaPersonagemEntityPK.class)
public class HistoriaPersonagemEntity {
    private int historiaId;
    private int personagemId;

    @Id
    @Column(name = "historia_id")
    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
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

        HistoriaPersonagemEntity that = (HistoriaPersonagemEntity) o;

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
