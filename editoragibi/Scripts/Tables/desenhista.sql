create table desenhista (
    desenhista_id serial,
    nome_desenhista varchar(20) not null,
    pais_nascimento varchar(20) not null,
    data_nascimento_desenhista date not null,
    data_falecimento_desenhista date,
    endereco_desenhista varchar(25) not null,
    data_contratacao date not null,
    data_demissao date,
    primary key(desenhista_id)
)