package com.yorranpetrick.forumhub.service;

import com.yorranpetrick.forumhub.models.autor.Autor;
import com.yorranpetrick.forumhub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor cadastrarAutor(Autor autor){
        try {
            String id_autor = java.util.UUID.randomUUID().toString();
            autor.setIdAutor(id_autor);
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
            if(usuario.getTipoUsuario().equals("ADMINISTRADOR")) {
                return autorRepository.findAll();
            } else {
                throw new RuntimeException("Usuário não tem permissão para listar autores.");
            }
        }catch (Exception e) {
            throw new RuntimeException("Erro ao listar autores: " + e.getMessage());
        }
    }
}
