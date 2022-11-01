package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.ItemEdicaoRequest;
import com.grupo2.editoragibi.Api.Requests.PedidoConsignacaoRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido_consignacao")
public class PedidoConsignacaoController {

    public void teste(@RequestBody PedidoConsignacaoRequest pedido) {
        for (ItemEdicaoRequest i : pedido.getItens()) {
            System.out.println(i.getEdicaoId());
            System.out.println(i.getQuantidade());
        }
    }
}
