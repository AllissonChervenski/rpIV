create table personagem (
    personagem_id serial,
    nome_personagem varchar(20) not null,
    historico_personagem varchar(100),
    patente_personagem varchar(20),
    data_criacao date not null,
    primary key(personagem_id)
)