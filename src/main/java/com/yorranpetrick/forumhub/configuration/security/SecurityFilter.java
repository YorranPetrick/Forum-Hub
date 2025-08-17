package com.yorranpetrick.forumhub.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    // Este filtro é responsável por interceptar as requisições HTTP e realizar a autenticação do usuário
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Request onde está vindo a requisição
        //Response onde está vindo a resposta
        //FilterChain é a cadeia de filtros que a requisição vai passar

        var tokenJWT = recuperarToken(request);
        filterChain.doFilter(request, response); // Continua a cadeia de filtros

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization"); // Recupera o cabeçalho de autorização da requisição HTTP

        if (authorizationHeader == null) {
                throw new  RuntimeException("Token JWT não encontrado no cabeçalho de autorização");
        }
        return authorizationHeader.replace("Bearer ", ""); // Remove o prefixo "Bearer " do token JWT
    }
}
