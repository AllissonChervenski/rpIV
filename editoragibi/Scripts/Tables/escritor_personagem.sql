create table escritor_personagem (
    escritor_id integer references escritor(escritor_id),
    personagem_id integer references personagem(personagem_id),
    primary key(escritor_id, personagem_id)
)