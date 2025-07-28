package com.yorranpetrick.forumhub.service;

import com.yorranpetrick.forumhub.models.Autor;
import com.yorranpetrick.forumhub.models.Topico;
import com.yorranpetrick.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico cadastrarTopico(Topico topico, Autor autor){
        try {
            String id_topico = java.util.UUID.randomUUID().toString(); // Gera um ID único
            topico.setIdTopico(id_topico);
            topico.setAutor(autor);
            topicoRepository.save(topico);
            return topico;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar tópico: " + e.getMessage());
        }
    }
}
