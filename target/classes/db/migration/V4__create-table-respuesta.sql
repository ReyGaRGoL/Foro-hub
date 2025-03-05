create table respuesta(

                          id bigint not null auto_increment,
                          mensaje varchar(500) not null,
                          fecha_creacion datetime not null,
                          id_usuario bigint not null,
                          id_topico bigint not null,

                          primary key(id),
                          constraint fk_respuesta_usuario_id foreign key(id_usuario) references usuario(id),
                          constraint fk_respuesta_topico_id foreign key(id_topico) references topico(id)
);