create table gibi (
    gibi_id serial,
    titulo_gibi varchar(20) not null,
    data_inicio_publi date not null,
    data_encerramento date,
    descontinuado_gibi varchar(20) not null,
    primary key(gibi_id)
)