package com.Forohub.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        Long idUsuario,
        @NotBlank(message = "no se permiten datos vacios")
        @NotNull(message = "ingrese un titulo")
        String titulo,
        @NotBlank(message = "no se permiten datos vacios")
        @NotNull(message = "ingrese un mensaje")
        String mensaje,
        @NotBlank(message = "no se permiten datos vacios")
        @NotNull(message = "ingrese un nombreCurso")
        String nombreCurso
) {

    public DatosTopico (Topico topico){

        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getCurso().getNombre());

    }

}
