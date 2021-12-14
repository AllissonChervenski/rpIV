package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;

@Entity
@Table(name = "escritor_historia", schema = "public", catalog = "sistemagibi")
@IdClass(EscritorHistoriaEntityPK.class)
public class EscritorHistoriaEntity {
    private int escritorId;
    private int historiaId;

    @Id
    @Column(name = "escritor_id")
    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    @Id
    @Column(name = "historia_id")
    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EscritorHistoriaEntity that = (EscritorHistoriaEntity) o;

        if (escritorId != that.escritorId) return false;
        if (historiaId != that.historiaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = escritorId;
        result = 31 * result + historiaId;
        return result;
    }
}
