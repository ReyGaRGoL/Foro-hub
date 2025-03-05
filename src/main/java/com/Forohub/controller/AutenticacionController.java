package com.Forohub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Forohub.infra.security.DatosJwtToken;
import com.Forohub.infra.security.TokenService;
import com.Forohub.domain.usuario.DatosAutenticacionUsuario;
import com.Forohub.domain.usuario.Usuario;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity autenticar(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
		Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correo(), datosAutenticacionUsuario.contraseña());
		var usuarioAutenticado = authenticationManager.authenticate(authToken);
		
		var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new DatosJwtToken(jwtToken));
	}
}
