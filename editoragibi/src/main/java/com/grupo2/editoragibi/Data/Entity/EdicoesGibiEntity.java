package com.grupo2.editoragibi.Data.Entity;

import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.editor.Editor;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table(name = "edicao")
public class EdicoesGibiEntity extends EdicoesGibi {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator =  "edicao_edicao_id_seq"
    )
    @Column(name = "edicao_id")
    private int edicaoGibi_id;

    @Column(name = "numero_edicao")
    private int nroEdicao;

    @Column(name = "data_edicao")
    private LocalDate dataPub;

    @Column(name = "publicada_edicao")
    private boolean publicada;

    @Column(name = "numero_exemplares_impressos")
    private int numeroExemplaresImpressas;

    @ManyToOne
    @JoinColumn(name = "gibi_id")
    private GibiEntity gibi;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_historia", joinColumns = {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "historia_id")})
    private HistoriaEntity historia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "edicoes_escritor", joinColumns = {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "escritor_id")})
    private List<EscritorEntity> escritorEntity = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_personagem", joinColumns =  {@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "personagem_id")})
    private List<PersonagemEntity> personagemEntity = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "edicoes_desenhista", joinColumns ={@JoinColumn(name = "edicao_id")}, inverseJoinColumns = {@JoinColumn(name = "desenhista_id")})
    private List<DesenhistaEntity> desenhistaEntity = new ArrayList<>();



    public EdicoesGibiEntity(int nroEdicao, LocalDate dataPub) {
        this.nroEdicao = nroEdicao;
        this.dataPub = dataPub;
    }

    public HistoriaEntity getHistoriaEntity() {
        return historia;
    }

    public EdicoesGibiEntity(int edicaoGibiId, int nroEdicao, LocalDate dataPub) {
        this.edicaoGibi_id = edicaoGibiId;
        this.nroEdicao = nroEdicao;
        this.dataPub = dataPub;
    }

    public EdicoesGibiEntity() {
    }

    public int getNumeroExemplaresImpressas() {
        return numeroExemplaresImpressas;
    }

    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        this.numeroExemplaresImpressas = numeroExemplaresImpressas;
    }

    public long getEdicaoGibiId() {
        return edicaoGibi_id;
    }

    public void setEdicaoGibiId(int id) {
        this.edicaoGibi_id = id;
    }

    public int getNroEdicao() {
        return nroEdicao;
    }

    public void setNroEdicao(int nroEdicao) {
        this.nroEdicao = nroEdicao;
    }

    public LocalDate getDataPub() {
        return dataPub;
    }

    public void setDataPub(LocalDate dataPub) {
        this.dataPub = dataPub;
    }

}
