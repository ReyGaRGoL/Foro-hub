create table respuesta(
	
	id bigint not null auto_increment,
	mensaje varchar(500) not null,
	fechaCreacion datetime not null,
	idUsuario bigint not null,
	idTopico bigint not null,
	
	primary key(id),
	constraint fk_respuesta_usuario_id foreign key(idUsuario) references usuario(id),
	constraint fk_respuesta_topico_id foreign key(idTopico) references topico(id)
);