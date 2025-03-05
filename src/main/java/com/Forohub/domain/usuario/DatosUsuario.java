package com.Forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
		@NotBlank(message = "no se permiten datos vacios")
		@NotNull(message = "ingrese un nombre")
		String nombre,
		@NotBlank(message = "no se permiten datos vacios")
		@NotNull (message = "ingrese un correo")
		@Email(message = "El correo ingresado necesita un . y un @") String correo,
		@NotBlank(message = "no se permiten datos vacios") @NotNull String contraseña
		) {

}
