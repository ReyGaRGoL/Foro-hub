package com.Forohub.controller;

import java.net.URI;
import java.util.Optional;

import com.Forohub.domain.ValidacionExcepcion;
import com.Forohub.domain.curso.Curso;
import com.Forohub.domain.curso.CursoRepository;
import com.Forohub.domain.topico.*;
import com.Forohub.domain.usuario.Usuario;
import com.Forohub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name="bearer-key")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<DatosTopico> crear(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){

		Curso curso = cursoRepository.findByNombre(datosTopico.nombreCurso());
		if(curso == null){
			throw new ValidacionExcepcion("El curso no existe en la base de datos");
		}

		Usuario usuario = usuarioRepository.findById(datosTopico.idUsuario()).orElse(null);
		if(usuario == null){
			throw new ValidacionExcepcion("El usuario no existe en la base de datos");
		}

		Topico topico = topicoRepository.save(new Topico(datosTopico, curso, usuario));

		URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(url).body(new DatosTopico(topico));
	}
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoTopico>> listar(@PageableDefault(size = 5) Pageable pageable){

		return ResponseEntity.ok(topicoRepository.findByActivoTrue(pageable).map(DatosListadoTopico::new));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DatosTopico> buscar(@PathVariable Long id){

		Topico topico = topicoRepository.findById(id).orElse(null);
		if (topico==null) {
			throw new ValidacionExcepcion("El topico no existe en la base de datos");
		}
		return ResponseEntity.ok(new DatosTopico(topico));
	}

	@PutMapping()
	@Transactional
	public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
		Topico topico = topicoRepository.findById(datosActualizarTopico.id()).orElse(null);
		if (topico == null) {
			throw new ValidacionExcepcion("El topico no existe en la base de datos");
		}
		topico.actualizarDatos(datosActualizarTopico);

		return ResponseEntity.ok(new DatosTopico(topico));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity eliminar(@PathVariable("id") Long id){
		Topico topico = topicoRepository.findById(id).orElse(null);
		if (topico == null) {
			throw new ValidacionExcepcion("El topico no existe en la base de datos");
		}
		topico.desactivarTopico();
		return ResponseEntity.noContent().build();
	}
}
