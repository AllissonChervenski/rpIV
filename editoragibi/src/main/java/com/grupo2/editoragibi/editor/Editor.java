package com.grupo2.editoragibi.editor;

import com.grupo2.editoragibi.edicoes.EdicoesGibi;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "editor")
public class Editor {

    @Id
    @Column(name = "editor_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "editor_editor_id_seq")
    private int editorId;

    @Column(name = "nome_editor")
    private String nomeEditor;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editor")
    private List<EdicoesGibi> edicoes;
}
