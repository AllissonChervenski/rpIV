package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "edicao", schema = "public", catalog = "sistemagibi")
public class EdicaoEntity {
    private int edicaoId;
    private int numeroEdicao;
    private Date dataEdicao;
    private boolean publicadaEdicao;
    private int numeroExemplaresImpressos;

    @Id
    @Column(name = "edicao_id")
    public int getEdicaoId() {
        return edicaoId;
    }

    public void setEdicaoId(int edicaoId) {
        this.edicaoId = edicaoId;
    }

    @Basic
    @Column(name = "numero_edicao")
    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    @Basic
    @Column(name = "data_edicao")
    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    @Basic
    @Column(name = "publicada_edicao")
    public boolean isPublicadaEdicao() {
        return publicadaEdicao;
    }

    public void setPublicadaEdicao(boolean publicadaEdicao) {
        this.publicadaEdicao = publicadaEdicao;
    }

    @Basic
    @Column(name = "numero_exemplares_impressos")
    public int getNumeroExemplaresImpressos() {
        return numeroExemplaresImpressos;
    }

    public void setNumeroExemplaresImpressos(int numeroExemplaresImpressos) {
        this.numeroExemplaresImpressos = numeroExemplaresImpressos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EdicaoEntity that = (EdicaoEntity) o;

        if (edicaoId != that.edicaoId) return false;
        if (numeroEdicao != that.numeroEdicao) return false;
        if (publicadaEdicao != that.publicadaEdicao) return false;
        if (numeroExemplaresImpressos != that.numeroExemplaresImpressos) return false;
        if (dataEdicao != null ? !dataEdicao.equals(that.dataEdicao) : that.dataEdicao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = edicaoId;
        result = 31 * result + numeroEdicao;
        result = 31 * result + (dataEdicao != null ? dataEdicao.hashCode() : 0);
        result = 31 * result + (publicadaEdicao ? 1 : 0);
        result = 31 * result + numeroExemplaresImpressos;
        return result;
    }
}
