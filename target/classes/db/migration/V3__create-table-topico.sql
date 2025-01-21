create table topico(
	
	id bigint not null auto_increment,
	titulo varchar(100) not null,
	mensaje varchar(500) not null,
	fechaCreacion datetime not null,
	activo tinyint default 1,
	idUsuario bigint not null,
	idCurso bigint not null,
	
	primary key(id),
	constraint fk_topico_usuario_id foreign key(idUsuario) references usuario(id),
	constraint fk_topico_curso_id foreign key(idCurso) references curso(id)
);