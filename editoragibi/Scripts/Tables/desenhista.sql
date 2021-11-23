create table desenhista (
    desenhista_id serial,
    nome_desenhista varchar(20) not null,
    endereco_desenhista varchar(25) not null,
    data_contratacao date not null,
    data_demissao date,
    primary key(desenhista_id)
)