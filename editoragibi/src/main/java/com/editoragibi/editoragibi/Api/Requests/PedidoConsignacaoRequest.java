package com.editoragibi.editoragibi.Api.Requests;

import lombok.Data;

import java.util.List;

@Data
public class PedidoConsignacaoRequest {

    private List<ItemEdicaoRequest> itens;
}
