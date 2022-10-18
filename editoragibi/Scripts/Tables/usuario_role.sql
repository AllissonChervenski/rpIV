create table usuario_role (
    user_name varchar(20) references usuario,
    role_id integer references role,
    primary key(user_name, role_id)
)