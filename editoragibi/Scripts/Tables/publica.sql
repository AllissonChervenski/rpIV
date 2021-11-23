create table publica (
    publica_id serial,
    edicao_id integer references edicao(edicao_id),
    historia_id integer references historia(historia_id),
    pagina_inicial integer not null,
    primary key(publica_id, edicao_id, historia_id)
)