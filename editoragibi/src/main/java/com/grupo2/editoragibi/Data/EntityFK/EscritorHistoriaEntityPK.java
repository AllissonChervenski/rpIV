package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EscritorHistoriaEntityPK implements Serializable {
    private int escritorId;
    private int historiaId;

    @Column(name = "escritor_id")
    @Id
    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    @Column(name = "historia_id")
    @Id
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

        EscritorHistoriaEntityPK that = (EscritorHistoriaEntityPK) o;

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
