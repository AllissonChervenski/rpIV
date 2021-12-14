package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "desenhista", schema = "public", catalog = "sistemagibi")
public class DesenhistaEntity {
    private int desenhistaId;
    private String nomeDesenhista;
    private String enderecoDesenhista;
    private Date dataContratacao;
    private Date dataDemissao;

    @Id
    @Column(name = "desenhista_id")
    public int getDesenhistaId() {
        return desenhistaId;
    }

    public void setDesenhistaId(int desenhistaId) {
        this.desenhistaId = desenhistaId;
    }

    @Basic
    @Column(name = "nome_desenhista")
    public String getNomeDesenhista() {
        return nomeDesenhista;
    }

    public void setNomeDesenhista(String nomeDesenhista) {
        this.nomeDesenhista = nomeDesenhista;
    }

    @Basic
    @Column(name = "endereco_desenhista")
    public String getEnderecoDesenhista() {
        return enderecoDesenhista;
    }

    public void setEnderecoDesenhista(String enderecoDesenhista) {
        this.enderecoDesenhista = enderecoDesenhista;
    }

    @Basic
    @Column(name = "data_contratacao")
    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Basic
    @Column(name = "data_demissao")
    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DesenhistaEntity that = (DesenhistaEntity) o;

        if (desenhistaId != that.desenhistaId) return false;
        if (nomeDesenhista != null ? !nomeDesenhista.equals(that.nomeDesenhista) : that.nomeDesenhista != null)
            return false;
        if (enderecoDesenhista != null ? !enderecoDesenhista.equals(that.enderecoDesenhista) : that.enderecoDesenhista != null)
            return false;
        if (dataContratacao != null ? !dataContratacao.equals(that.dataContratacao) : that.dataContratacao != null)
            return false;
        if (dataDemissao != null ? !dataDemissao.equals(that.dataDemissao) : that.dataDemissao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = desenhistaId;
        result = 31 * result + (nomeDesenhista != null ? nomeDesenhista.hashCode() : 0);
        result = 31 * result + (enderecoDesenhista != null ? enderecoDesenhista.hashCode() : 0);
        result = 31 * result + (dataContratacao != null ? dataContratacao.hashCode() : 0);
        result = 31 * result + (dataDemissao != null ? dataDemissao.hashCode() : 0);
        return result;
    }
}
