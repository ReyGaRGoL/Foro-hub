package com.Forohub.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidacionExcepcion extends RuntimeException{

    public ValidacionExcepcion(String  mensaje){
        super(mensaje);
    }
}
