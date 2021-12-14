package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "escritor", schema = "public", catalog = "sistemagibi")
public class EscritorEntity {
    private int escritorId;
    private String nomeEscritor;
    private String enderecoEscritor;
    private String telefoneEscritor;
    private String emailEscritor;
    private Date dataContratacao;
    private Date dataDemissao;

    @Id
    @Column(name = "escritor_id")
    public int getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(int escritorId) {
        this.escritorId = escritorId;
    }

    @Basic
    @Column(name = "nome_escritor")
    public String getNomeEscritor() {
        return nomeEscritor;
    }

    public void setNomeEscritor(String nomeEscritor) {
        this.nomeEscritor = nomeEscritor;
    }

    @Basic
    @Column(name = "endereco_escritor")
    public String getEnderecoEscritor() {
        return enderecoEscritor;
    }

    public void setEnderecoEscritor(String enderecoEscritor) {
        this.enderecoEscritor = enderecoEscritor;
    }

    @Basic
    @Column(name = "telefone_escritor")
    public String getTelefoneEscritor() {
        return telefoneEscritor;
    }

    public void setTelefoneEscritor(String telefoneEscritor) {
        this.telefoneEscritor = telefoneEscritor;
    }

    @Basic
    @Column(name = "email_escritor")
    public String getEmailEscritor() {
        return emailEscritor;
    }

    public void setEmailEscritor(String emailEscritor) {
        this.emailEscritor = emailEscritor;
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

        EscritorEntity that = (EscritorEntity) o;

        if (escritorId != that.escritorId) return false;
        if (nomeEscritor != null ? !nomeEscritor.equals(that.nomeEscritor) : that.nomeEscritor != null) return false;
        if (enderecoEscritor != null ? !enderecoEscritor.equals(that.enderecoEscritor) : that.enderecoEscritor != null)
            return false;
        if (telefoneEscritor != null ? !telefoneEscritor.equals(that.telefoneEscritor) : that.telefoneEscritor != null)
            return false;
        if (emailEscritor != null ? !emailEscritor.equals(that.emailEscritor) : that.emailEscritor != null)
            return false;
        if (dataContratacao != null ? !dataContratacao.equals(that.dataContratacao) : that.dataContratacao != null)
            return false;
        if (dataDemissao != null ? !dataDemissao.equals(that.dataDemissao) : that.dataDemissao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = escritorId;
        result = 31 * result + (nomeEscritor != null ? nomeEscritor.hashCode() : 0);
        result = 31 * result + (enderecoEscritor != null ? enderecoEscritor.hashCode() : 0);
        result = 31 * result + (telefoneEscritor != null ? telefoneEscritor.hashCode() : 0);
        result = 31 * result + (emailEscritor != null ? emailEscritor.hashCode() : 0);
        result = 31 * result + (dataContratacao != null ? dataContratacao.hashCode() : 0);
        result = 31 * result + (dataDemissao != null ? dataDemissao.hashCode() : 0);
        return result;
    }
}
