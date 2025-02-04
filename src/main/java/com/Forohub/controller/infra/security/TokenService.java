package com.Forohub.controller.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Forohub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {

	@Value("api.security.secret")
	private String apiSecret;

	public String generarToken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(apiSecret);
			return JWT.create().withIssuer("forohub")
					.withSubject(usuario.getCorreo())
					.withClaim("id", usuario.getId())
					.withExpiresAt(generarFechaExpiracion())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException();
		}

	}

	private Instant generarFechaExpiracion() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
	}
}
