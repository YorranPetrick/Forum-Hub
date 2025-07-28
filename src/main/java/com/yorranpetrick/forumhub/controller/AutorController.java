package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.models.Autor;
import com.yorranpetrick.forumhub.service.AutorService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/autorApi")
public class AutorController {

    public AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor) {
       return autorService.cadastrarAutor(autor); // Utiliza o service para cadastrar o autor
    }

    @GetMapping("{idAutor}")
    public Autor pesquisarAutor(@PathVariable("idAutor") String idAutor) {
        return autorService.pesquisarAutor(idAutor); // Utiliza o service para pesquisar o autor pelo ID
    }
}
