create table transportadora (
    transportadora_id serial,
    nome_transportadora varchar(20) not null,
    endereco_transportadora varchar(25) not null,
    telefone_transportadora varchar(11) not null,
    primary key(transportadora_id)
)