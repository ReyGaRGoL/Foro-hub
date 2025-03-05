create table topico(

                       id bigint not null auto_increment,
                       titulo varchar(100) not null,
                       mensaje varchar(500) not null,
                       fecha_creacion datetime not null,
                       activo tinyint default 1,
                       id_usuario bigint not null,
                       id_curso bigint not null,

                       primary key(id),
                       constraint fk_topico_usuario_id foreign key(id_usuario) references usuario(id),
                       constraint fk_topico_curso_id foreign key(id_curso) references curso(id)
);