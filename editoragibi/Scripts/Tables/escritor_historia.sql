create table escritor_historia (
    escritor_id integer references escritor(escritor_id),
    historia_id integer references historia(historia_id),
    primary key(escritor_id, historia_id)
)