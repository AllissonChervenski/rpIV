create table banca (
    banca_id serial,
    nome_proprietario varchar(20) not null,
    nome_banca varchar(20) not null,
    cnpj varchar(14),
    endereco_banca varchar(25) not null,
    cep varchar(8),
    telefone_banca varchar(11) not null,
    primary key(banca_id)
)