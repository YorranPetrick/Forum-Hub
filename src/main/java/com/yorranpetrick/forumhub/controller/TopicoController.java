package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.models.topico.Topico;
import com.yorranpetrick.forumhub.service.AutorService;
import com.yorranpetrick.forumhub.service.TopicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicoApi")

public class TopicoController {

    private AutorService autorService;
    private TopicoService topicoService;

    public TopicoController(AutorService autorService, TopicoService topicoService) {
        this.autorService = autorService;
        this.topicoService = topicoService;
    }

    @PostMapping("{idAutor}")
    public Topico cadastrarTopico(@PathVariable("idAutor") String idAutor, @RequestBody Topico topico) {
        var autor = autorService.pesquisarAutor(idAutor); // Utiliza o service para pesquisar o autor pelo ID
        if (autor == null) {
            throw new RuntimeException("Autor não encontrado com o ID: " + idAutor);
        }
        return topicoService.cadastrarTopico(topico, autor); // Utiliza o service para cadastrar o tópico
    }

    @GetMapping("{idAutor}")
    public List<Topico> listarTopicosAutor(@PathVariable("idAutor") String idAutor){
        return topicoService.listarTopicosAutor(idAutor); // Utiliza o service para listar os tópicos do autor
    }

    @GetMapping("/topico-especifico/{idTopico}")
    public Topico listarTopicoEspecifico(@PathVariable("idTopico") String idTopico){
        return topicoService.listarTopicoEsperifico(idTopico); // Utiliza o service para listar o tópico específico
    }

    @DeleteMapping("/deletar-topico/{idTopico}")
    public void deteleTopico(@PathVariable("idTopico") String idTopico) {
        topicoService.deletarTopico(idTopico);
    }

    @PutMapping("/atualizar-topico/{idTopico}")
    public void atualizarTopico(@PathVariable String idTopico, @RequestBody Topico topico) {
        topicoService.atualizarTopico(topico, idTopico);
    }
}
