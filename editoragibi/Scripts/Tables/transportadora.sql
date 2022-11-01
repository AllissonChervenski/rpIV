create table transportadora (
    transportadora_id serial,
    nome_transportadora varchar(20) not null,
    cnpj varchar(14),
    endereco_transportadora varchar(25) not null,
    telefone_transportadora varchar(11) not null,
    local_partida varchar(50),
    local_destino varchar (50),
    rota_trabalho varchar (100),
    primary key(transportadora_id)
)