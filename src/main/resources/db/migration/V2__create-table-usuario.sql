create table usuario(
	
	id bigint not null auto_increment,
	nombre varchar(100) not null,
	correo varchar(200) not null,
	contraseña varchar(200) not null,
	primary key(id)
);