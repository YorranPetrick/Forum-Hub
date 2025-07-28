package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.models.Autor;
import com.yorranpetrick.forumhub.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/autorApi")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor) {
        String id_autor = java.util.UUID.randomUUID().toString();
        autor.setIdAutor(id_autor);
        autorRepository.save(autor);
        return autor;

    }

    @GetMapping
    public Autor pesquisarAutor(@RequestParam String idAutor) {
        return autorRepository.findById(idAutor).orElse(null);
    }
}
