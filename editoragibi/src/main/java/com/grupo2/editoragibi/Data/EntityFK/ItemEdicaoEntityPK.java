package com.grupo2.editoragibi.Data.EntityFK;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemEdicaoEntityPK implements Serializable {
    private int itemId;
    private int pedidoConsignacaoId;

    @Column(name = "item_id")
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "pedido_consignacao_id")
    @Id
    public int getPedidoConsignacaoId() {
        return pedidoConsignacaoId;
    }

    public void setPedidoConsignacaoId(int pedidoConsignacaoId) {
        this.pedidoConsignacaoId = pedidoConsignacaoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEdicaoEntityPK that = (ItemEdicaoEntityPK) o;

        if (itemId != that.itemId) return false;
        if (pedidoConsignacaoId != that.pedidoConsignacaoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + pedidoConsignacaoId;
        return result;
    }
}
