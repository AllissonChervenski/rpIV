create table historia (
    historia_id serial,
    titulo_historia varchar(20) not null,
    total_paginas integer not null,
    data_producao date not null,
    desenhista_artefinaliza_id integer references desenhista(desenhista_id),
    desenhista_desenha_id integer references desenhista(desenhista_id),
    escritor_id integer references escritor(escritor_id),
    edicao_id integer references edicao(edicao_id),
    primary key(historia_id)
)