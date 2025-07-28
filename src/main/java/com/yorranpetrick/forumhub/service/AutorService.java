package com.yorranpetrick.forumhub.service;

import com.yorranpetrick.forumhub.models.Autor;
import com.yorranpetrick.forumhub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

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
}
