package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "editor", schema = "public", catalog = "sistemagibi")
public class EditorEntity {
    private int editorId;
    private String nomeEditor;
    private Date dataInicio;
    private Date dataFim;

    @Id
    @Column(name = "editor_id")
    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    @Basic
    @Column(name = "nome_editor")
    public String getNomeEditor() {
        return nomeEditor;
    }

    public void setNomeEditor(String nomeEditor) {
        this.nomeEditor = nomeEditor;
    }

    @Basic
    @Column(name = "data_inicio")
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Basic
    @Column(name = "data_fim")
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditorEntity that = (EditorEntity) o;

        if (editorId != that.editorId) return false;
        if (nomeEditor != null ? !nomeEditor.equals(that.nomeEditor) : that.nomeEditor != null) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = editorId;
        result = 31 * result + (nomeEditor != null ? nomeEditor.hashCode() : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        return result;
    }
}
