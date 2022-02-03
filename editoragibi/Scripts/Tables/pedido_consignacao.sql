create table pedido_consignacao (
    pedido_consignacao_id serial,
    data_pedido date not null,
    atendido_pedido boolean not null,
    entregue_pedido boolean not null,
    banca_id integer not null references banca(banca_id),
    transportadora_id integer not null references transportadora(transportadora_id),
    primary key(pedido_consignacao_id)
)