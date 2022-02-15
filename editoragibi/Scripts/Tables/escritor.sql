create table escritor (
    escritor_id serial,
    nome_escritor varchar(20) not null,
    endereco_escritor varchar(25) not null,
    telefone_escritor varchar(11) not null,
    email_escritor varchar(30) not null,
    data_contratacao date not null,
    data_demissao date,
    primary key (escritor_id)
)