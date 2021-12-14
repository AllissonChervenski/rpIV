package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "personagem", schema = "public", catalog = "sistemagibi")
public class PersonagemEntity {
    private int personagemId;
    private String nomePersonagem;
    private String historicoPersonagem;
    private String patentePersonagem;
    private Date dataCriacao;

    @Id
    @Column(name = "personagem_id")
    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    @Basic
    @Column(name = "nome_personagem")
    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    @Basic
    @Column(name = "historico_personagem")
    public String getHistoricoPersonagem() {
        return historicoPersonagem;
    }

    public void setHistoricoPersonagem(String historicoPersonagem) {
        this.historicoPersonagem = historicoPersonagem;
    }

    @Basic
    @Column(name = "patente_personagem")
    public String getPatentePersonagem() {
        return patentePersonagem;
    }

    public void setPatentePersonagem(String patentePersonagem) {
        this.patentePersonagem = patentePersonagem;
    }

    @Basic
    @Column(name = "data_criacao")
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonagemEntity that = (PersonagemEntity) o;

        if (personagemId != that.personagemId) return false;
        if (nomePersonagem != null ? !nomePersonagem.equals(that.nomePersonagem) : that.nomePersonagem != null)
            return false;
        if (historicoPersonagem != null ? !historicoPersonagem.equals(that.historicoPersonagem) : that.historicoPersonagem != null)
            return false;
        if (patentePersonagem != null ? !patentePersonagem.equals(that.patentePersonagem) : that.patentePersonagem != null)
            return false;
        if (dataCriacao != null ? !dataCriacao.equals(that.dataCriacao) : that.dataCriacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personagemId;
        result = 31 * result + (nomePersonagem != null ? nomePersonagem.hashCode() : 0);
        result = 31 * result + (historicoPersonagem != null ? historicoPersonagem.hashCode() : 0);
        result = 31 * result + (patentePersonagem != null ? patentePersonagem.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        return result;
    }
}
