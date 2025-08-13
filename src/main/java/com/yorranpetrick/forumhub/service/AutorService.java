package com.yorranpetrick.forumhub.service;

import com.yorranpetrick.forumhub.configuration.security.SecurityConfiguration;
import com.yorranpetrick.forumhub.models.autor.Autor;
import com.yorranpetrick.forumhub.models.autor.TiposAutores;
import com.yorranpetrick.forumhub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService { // Implementa UserDetailsService para integração com Spring Security

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private SecurityConfiguration securityConfiguration;

    public Autor cadastrarAutor(Autor autor){
        try {
            String id_autor = java.util.UUID.randomUUID().toString();
            autor.setIdAutor(id_autor);
            var senhaCriptografada = securityConfiguration.passwordEncoder().encode(autor.getSenha());
            autor.setSenha(senhaCriptografada);
            autorRepository.save(autor);
            return autor;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar autor: " + e.getMessage());
        }
    }

    public Autor pesquisarAutor(String idAutor) {
        try {
            var autorPesquisado = autorRepository.findById(idAutor).orElse(null);
            if (autorPesquisado == null) {
                throw new RuntimeException("Autor não encontrado com o ID: " + idAutor);
            }
            return autorPesquisado;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar autor: " + e.getMessage());
        }
    }

    public List<Autor> listarAutores(String idUsuarioLogado) {
        try {
            var usuario = pesquisarAutor(idUsuarioLogado);

            if(usuario.getTipoUsuario().equals(TiposAutores.ADMINISTRADOR)){
                return autorRepository.findAll();
            } else {
                throw new RuntimeException("Usuário não tem permissão para listar autores.");
            }
        }catch (Exception e) {
            throw new RuntimeException("Erro ao listar autores: " + e.getMessage());
        }
    }

    public Boolean validacaoTipoAutor(Autor autor){
        try {
            TiposAutores.valueOf(autor.getTipoUsuario().toString().toUpperCase()); //Verifica se o tipo de autor é valido
            return true;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de Autor Invalido, Verifique os Tipos Disponiveis e tente novamente : " + e.getMessage());
        }
    }

}
