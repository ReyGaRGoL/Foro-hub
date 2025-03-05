package com.Forohub.controller;

import com.Forohub.domain.curso.Curso;
import com.Forohub.domain.curso.CursoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name="bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> listar(){
        List<Curso> cursos = cursoRepository.findAll();
        return ResponseEntity.ok(cursos);
    }




    @PostMapping
    public ResponseEntity listar(@RequestBody @Valid Curso curso, UriComponentsBuilder uriBuilder){
        var datos=cursoRepository.save(curso);

        URI url = uriBuilder.path("curso/{id}").buildAndExpand(datos.getId()).toUri();
        return ResponseEntity.created(url).body(datos);
    }

}
