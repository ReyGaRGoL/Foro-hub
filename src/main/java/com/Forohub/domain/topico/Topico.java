package com.Forohub.domain.topico;

import java.time.LocalDateTime;
import java.util.List;

import com.Forohub.domain.curso.Curso;
import com.Forohub.domain.respuesta.Respuesta;
import com.Forohub.domain.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topico")
@Entity(name = "Topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Topico {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion;
	
	private boolean activo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario",referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCurso",referencedColumnName = "id")
	private Curso curso;
	
	@OneToMany(mappedBy = "topico")
	private List<Respuesta> respuestas; 

}
