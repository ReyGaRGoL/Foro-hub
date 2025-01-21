package com.Forohub.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TopicoController {

	@PostMapping
	public ResponseEntity crear(UriComponentsBuilder uriComponentsBuilder){
		URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(0).toUri();
		return ResponseEntity.created(url).body(null);
	}
	
	@GetMapping
	public ResponseEntity listar(UriComponentsBuilder uriComponentsBuilder){
		URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(0).toUri();
		return ResponseEntity.created(url).body(null);
	}
}
