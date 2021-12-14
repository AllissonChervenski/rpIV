package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "historia", schema = "public", catalog = "sistemagibi")
public class HistoriaEntity {
    private int historiaId;
    private String tituloHistoria;
    private int totalPaginas;
    private Date dataProducao;

    @Id
    @Column(name = "historia_id")
    public int getHistoriaId() {
        return historiaId;
    }

    public void setHistoriaId(int historiaId) {
        this.historiaId = historiaId;
    }

    @Basic
    @Column(name = "titulo_historia")
    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    @Basic
    @Column(name = "total_paginas")
    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    @Basic
    @Column(name = "data_producao")
    public Date getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(Date dataProducao) {
        this.dataProducao = dataProducao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoriaEntity that = (HistoriaEntity) o;

        if (historiaId != that.historiaId) return false;
        if (totalPaginas != that.totalPaginas) return false;
        if (tituloHistoria != null ? !tituloHistoria.equals(that.tituloHistoria) : that.tituloHistoria != null)
            return false;
        if (dataProducao != null ? !dataProducao.equals(that.dataProducao) : that.dataProducao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = historiaId;
        result = 31 * result + (tituloHistoria != null ? tituloHistoria.hashCode() : 0);
        result = 31 * result + totalPaginas;
        result = 31 * result + (dataProducao != null ? dataProducao.hashCode() : 0);
        return result;
    }
}
