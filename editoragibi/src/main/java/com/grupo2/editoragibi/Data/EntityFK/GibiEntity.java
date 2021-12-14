package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "gibi", schema = "public", catalog = "sistemagibi")
public class GibiEntity {
    private int gibiId;
    private String tituloGibi;
    private Date dataInicioPubli;
    private Date dataEncerramento;

    @Id
    @Column(name = "gibi_id")
    public int getGibiId() {
        return gibiId;
    }

    public void setGibiId(int gibiId) {
        this.gibiId = gibiId;
    }

    @Basic
    @Column(name = "titulo_gibi")
    public String getTituloGibi() {
        return tituloGibi;
    }

    public void setTituloGibi(String tituloGibi) {
        this.tituloGibi = tituloGibi;
    }

    @Basic
    @Column(name = "data_inicio_publi")
    public Date getDataInicioPubli() {
        return dataInicioPubli;
    }

    public void setDataInicioPubli(Date dataInicioPubli) {
        this.dataInicioPubli = dataInicioPubli;
    }

    @Basic
    @Column(name = "data_encerramento")
    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GibiEntity that = (GibiEntity) o;

        if (gibiId != that.gibiId) return false;
        if (tituloGibi != null ? !tituloGibi.equals(that.tituloGibi) : that.tituloGibi != null) return false;
        if (dataInicioPubli != null ? !dataInicioPubli.equals(that.dataInicioPubli) : that.dataInicioPubli != null)
            return false;
        if (dataEncerramento != null ? !dataEncerramento.equals(that.dataEncerramento) : that.dataEncerramento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gibiId;
        result = 31 * result + (tituloGibi != null ? tituloGibi.hashCode() : 0);
        result = 31 * result + (dataInicioPubli != null ? dataInicioPubli.hashCode() : 0);
        result = 31 * result + (dataEncerramento != null ? dataEncerramento.hashCode() : 0);
        return result;
    }
}
