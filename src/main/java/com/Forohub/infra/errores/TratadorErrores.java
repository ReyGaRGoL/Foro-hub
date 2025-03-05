package com.Forohub.infra.errores;


import com.Forohub.domain.ValidacionExcepcion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacionExcepcion.class)
    public ResponseEntity tratarErrores( ValidacionExcepcion e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroresValidacion( MethodArgumentNotValidException e ){
        return ResponseEntity.badRequest().body(e.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarErroresValidacion( SQLIntegrityConstraintViolationException e ){
        return ResponseEntity.badRequest().body("Usuario no encontrado");
    }





}
