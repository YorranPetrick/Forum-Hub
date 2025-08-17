package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.configuration.security.DadosTokenJWT;
import com.yorranpetrick.forumhub.configuration.security.TokenConfiguration;
import com.yorranpetrick.forumhub.models.autor.Autor;
import com.yorranpetrick.forumhub.models.autor.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenConfiguration tokenConfiguration;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Validated DadosAutenticacao dadosAutenticacao) {
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.nome(), dadosAutenticacao.senha());
        var autenticacao = authenticationManager.authenticate(token);

        var tokenJWT = tokenConfiguration.gerarToken((Autor) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
