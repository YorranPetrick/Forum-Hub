package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.models.Topico;
import com.yorranpetrick.forumhub.repository.AutorRepository;
import com.yorranpetrick.forumhub.repository.TopicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicoApi")

public class TopicoController {
    private TopicoRepository topicoRepository;
    private AutorRepository autorRepository;

    public TopicoController(TopicoRepository topicoRepository, AutorRepository autorRepository) {
        this.topicoRepository = topicoRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public Topico cadastrarTopico(@RequestParam String idAutor, @RequestBody Topico topico) {
        var autor = autorRepository.findById(idAutor).orElse(null);
        if (autor == null) {
            throw new RuntimeException("Autor não encontrado com o ID: " + idAutor);
        }

        String id_topico = java.util.UUID.randomUUID().toString(); // Gera um ID único
        topico.setIdTopico(id_topico);
        topico.setAutor(autor);
        topicoRepository.save(topico);
        return topico;
    }
}
