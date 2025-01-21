package com.Forohub.domain.respuesta;

import java.time.LocalDateTime;

import com.Forohub.domain.curso.Curso;
import com.Forohub.domain.topico.Topico;
import com.Forohub.domain.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respuesta")
@Entity(name = "Respuesta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Respuesta {

	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mensaje;
	private LocalDateTime fechaCreacion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario",referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name = "idTopico",referencedColumnName = "id")
	private Topico topico;
	
}
