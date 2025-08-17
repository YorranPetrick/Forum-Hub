package com.yorranpetrick.forumhub.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yorranpetrick.forumhub.models.autor.Autor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenConfiguration {

    @Value("${api.security.token.secret}")
    private String secret; //Realizar a Alteração Quando for para produção

    public String gerarToken(Autor autor) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("ForumHub")
                    .withSubject(autor.getNome())
                    .withClaim("senha", autor.getSenha())
                    .withClaim("id", autor.getIdAutor())
                    .withExpiresAt(dataExpiracao()) // Método para definir a data de expiração do token
                    .sign(algoritmo);


        } catch (JWTCreationException e) {
            throw new RuntimeException("erro ao gerar token jwt : " + e);
        }
    }

    public String getSubject(String tokenJWT){
        //Decodificando o Token JWT para obter o assunto (subject)
        //O assunto é o nome do usuário que foi autenticado
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("ForumHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
