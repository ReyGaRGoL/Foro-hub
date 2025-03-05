package com.Forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        Long idUsuario,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {

    public DatosListadoTopico (Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion());
    }
}
