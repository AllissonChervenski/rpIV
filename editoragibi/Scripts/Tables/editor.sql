create table editor (
    editor_id serial,
    nome_editor varchar(20) not null,
    data_inicio date not null,
    data_fim date,
    primary key(editor_id)
)