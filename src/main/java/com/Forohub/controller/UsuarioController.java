package com.Forohub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Forohub.domain.usuario.DatosUsuario;
import com.Forohub.domain.usuario.Usuario;
import com.Forohub.domain.usuario.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<Page<Usuario>> listar(){
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity crear(@RequestBody DatosUsuario datosUsuario, UriComponentsBuilder uriComponentsBuilder) {
		var usuarioGuardado=usuarioRepository.save(new Usuario(datosUsuario));
		
		URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(0).toUri();
		/*usuarioGuardado.getId()*/
		return ResponseEntity.created(url).body(usuarioGuardado);
	}
	
}
