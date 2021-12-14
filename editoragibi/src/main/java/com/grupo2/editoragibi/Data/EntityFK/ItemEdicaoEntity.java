package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.*;

@Entity
@Table(name = "item_edicao", schema = "public", catalog = "sistemagibi")
@IdClass(ItemEdicaoEntityPK.class)
public class ItemEdicaoEntity {
    private int itemId;
    private int pedidoConsignacaoId;
    private int quantidadeEdicao;

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @Column(name = "pedido_consignacao_id")
    public int getPedidoConsignacaoId() {
        return pedidoConsignacaoId;
    }

    public void setPedidoConsignacaoId(int pedidoConsignacaoId) {
        this.pedidoConsignacaoId = pedidoConsignacaoId;
    }

    @Basic
    @Column(name = "quantidade_edicao")
    public int getQuantidadeEdicao() {
        return quantidadeEdicao;
    }

    public void setQuantidadeEdicao(int quantidadeEdicao) {
        this.quantidadeEdicao = quantidadeEdicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEdicaoEntity that = (ItemEdicaoEntity) o;

        if (itemId != that.itemId) return false;
        if (pedidoConsignacaoId != that.pedidoConsignacaoId) return false;
        if (quantidadeEdicao != that.quantidadeEdicao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + pedidoConsignacaoId;
        result = 31 * result + quantidadeEdicao;
        return result;
    }
}
