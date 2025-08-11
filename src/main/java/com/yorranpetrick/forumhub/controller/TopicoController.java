package com.yorranpetrick.forumhub.controller;

import com.yorranpetrick.forumhub.models.topico.Topico;
import com.yorranpetrick.forumhub.service.AutorService;
import com.yorranpetrick.forumhub.service.TopicoService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Topico>> listarTopicosAutor(@PathVariable("idAutor") String idAutor){
        var topicos =  topicoService.listarTopicosAutor(idAutor); // Utiliza o service para listar os tópicos do autor
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/topico-especifico/{idTopico}")
    public ResponseEntity<Topico> listarTopicoEspecifico(@PathVariable("idTopico") String idTopico){
        var topico = topicoService.listarTopicoEsperifico(idTopico); // Utiliza o service para listar o tópico específico
        return ResponseEntity.ok(topico); // Retorna o tópico encontrado
    }


    @DeleteMapping("/deletar-topico/{idTopico}")
    public ResponseEntity deteleTopico(@PathVariable("idTopico") String idTopico) {
        topicoService.deletarTopico(idTopico);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar-topico/{idTopico}")
    public ResponseEntity atualizarTopico(@PathVariable String idTopico, @RequestBody Topico topico) {
        topicoService.atualizarTopico(topico, idTopico);

        return ResponseEntity.ok().build();
    }
}
