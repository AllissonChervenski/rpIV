create table item_edicao (
    item_id serial,
    pedido_consignacao_id integer references pedido_consignacao(pedido_consignacao_id),
    quantidade_edicao integer not null,
    banca_id integer not null references banca(banca_id),
    transportadora_id integer not null references transportadora(transportadora_id),
    edicao_id integer not null references edicao(edicao_id),
    primary key(item_id, pedido_consignacao_id)
)