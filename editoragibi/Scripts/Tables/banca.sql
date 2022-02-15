create table banca (
    banca_id serial,
    nome_banca varchar(20) not null,
    endereco_banca varchar(25) not null,
    telefone_banca varchar(11) not null,
    primary key(banca_id)
)