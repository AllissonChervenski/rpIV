package com.grupo2.editoragibi.Data.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "item_edicao")
public class ItemEdicaoEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_edicao_item_id_seq")
    private int itemEdicaoId;

    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(name = "pedido_consignacao_id", referencedColumnName = "pedido_consignacao_id")
    private PedidoConsignacaoEntity pedidoConsignacaoId;

    @Column(name = "quantidade_edicao")
    private int quantidade_edicao;

    @ManyToOne
    @JoinColumn(name = "banca_id")
    private BancaEntity banca;

    @ManyToOne
    @JoinColumn(name = "transportadora_id")
    private TransportadoraEntity transportadora;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    private EdicoesGibi edicao;
}
