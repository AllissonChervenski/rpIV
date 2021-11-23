create table historia_personagem (
    historia_id integer references historia(historia_id),
    personagem_id integer references personagem(personagem_id),
    primary key(historia_id, personagem_id)
)