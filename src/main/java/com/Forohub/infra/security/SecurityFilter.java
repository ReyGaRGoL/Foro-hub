package com.Forohub.infra.security;

import java.io.IOException;

import com.Forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		var token = request.getHeader("Authorization");

		if (token != null){
			token=token.replace("Bearer ", "");

			var subject=tokenService.getSubject(token);
			if (subject != null){
				var usuario = usuarioRepository.findByCorreo(subject);
				var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		filterChain.doFilter(request, response);
		
	}

}
