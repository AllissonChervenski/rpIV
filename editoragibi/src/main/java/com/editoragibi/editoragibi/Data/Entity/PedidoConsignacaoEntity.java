package com.editoragibi.editoragibi.Data.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pedido_consignacao")
public class PedidoConsignacaoEntity {

    @Id
    @Column(name = "pedido_consignacao_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pedido_consignacao_pedido_consignacao_id_seq")
    private int pedidoConsignacaoId;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "atendido_pedido")
    private boolean atendidoPedido;

    @Column(name = "entregue_pedido")
    private boolean entreguePedido;

    @ManyToOne
    @JoinColumn(name = "banca_id")
    private BancaEntity banca;

    @ManyToOne
    @JoinColumn(name = "transportadora_id")
    private TransportadoraEntity transportadora;
}
