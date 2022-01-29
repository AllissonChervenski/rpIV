create table usuario (
    user_name varchar(20),
    senha varchar(60) not null,
    role_id integer references role,
    primary key(user_name)
)