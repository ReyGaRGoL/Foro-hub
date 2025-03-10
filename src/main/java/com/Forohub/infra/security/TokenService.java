package com.Forohub.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import com.Forohub.domain.ValidacionExcepcion;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
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
			throw new ValidacionExcepcion(exception.getMessage());
		}

	}

	public String getSubject(String token) {

		DecodedJWT verifier =null;
		try {
			Algorithm algorithm = Algorithm.HMAC256(apiSecret);
			 verifier = JWT.require(algorithm)
					.withIssuer("forohub")
					.build()
					.verify(token);

		} catch (JWTVerificationException exception){
			
		}

		if(verifier == null){
			throw new ValidacionExcepcion("Verifier invalido");
		}

		return verifier.getSubject();
	}

	private Instant generarFechaExpiracion() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
	}
}
