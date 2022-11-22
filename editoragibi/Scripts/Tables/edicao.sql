create table edicao (
    edicao_id serial,
    numero_edicao integer not null,
    data_edicao date not null,
    publicada_edicao boolean not null,
    numero_exemplares_impressos integer not null,
    editor_id integer references editor(editor_id),
    gibi_id integer references gibi(gibi_id),
    historia_id integer references historia(historia_id),
    primary key(edicao_id)
)