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
	@JoinColumn(name = "id_Usuario",referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Curso",referencedColumnName = "id")
	private Curso curso;
	
	@OneToMany(mappedBy = "topico")
	private List<Respuesta> respuestas;




	public Topico(DatosTopico datosTopico, Curso curso, Usuario usuario) {

		this.titulo= datosTopico.titulo();
		this.mensaje= datosTopico.mensaje();
		this.fechaCreacion=LocalDateTime.now();
		this.activo=true;
		this.curso=curso;
		this.usuario=usuario;
	}

	public void desactivarTopico() {
		this.activo=false;
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

		if (datosActualizarTopico.titulo()!=null) {
			this.titulo=datosActualizarTopico.titulo();
		}

		if (datosActualizarTopico.mensaje()!=null) {
			this.mensaje=datosActualizarTopico.mensaje();
		}

	}
}
