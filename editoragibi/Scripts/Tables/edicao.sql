create table edicao (
    edicao_id serial,
    numero_edicao integer not null,
    data_inicio date not null,
    data_enc date,
    publicada_edicao boolean not null,
    numero_exemplares_impressos integer not null,
    editor_id integer references editor(editor_id),
    historia_id integer references historia(historia_id),
    primary key(edicao_id)
)