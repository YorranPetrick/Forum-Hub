package com.yorranpetrick.forumhub.service;

import com.yorranpetrick.forumhub.models.autor.Autor;
import com.yorranpetrick.forumhub.models.topico.Topico;
import com.yorranpetrick.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Topico> listarTopicosAutor(String idAutor){
        try {
            var topicos = topicoRepository.findAllByAutorId(idAutor);
            if (topicos.isEmpty()) {
                throw new RuntimeException("Nenhum tópico encontrado para o autor com ID: " + idAutor);
            }else return topicos;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao listar tópicos do autor: " + e.getMessage());
        }
    }

    public Topico listarTopicoEsperifico(String idTopico){
        try {
            var topico = topicoRepository.findById(idTopico).orElse(null);
            if(topico == null){
                throw new RuntimeException("Tópico não encontrado com o ID: " + idTopico);
            } else {
                return topico;
            }
        }catch (Exception e) {
            throw new RuntimeException("Erro ao listar tópico específico: " + e.getMessage());
        }
    }
    public void deletarTopico(String idTopico) {
        try {
            if (idTopico == null || idTopico.isEmpty()) {
                throw new IllegalArgumentException("ID do tópico não pode ser nulo ou vazio");
            }
            if (topicoRepository.findById(idTopico).orElse(null) != null){
                topicoRepository.deleteById(idTopico);
            }
        }catch (Exception e) {
            throw new RuntimeException("Erro ao deletar tópico: " + e.getMessage());
        }
    }

    public void atualizarTopico(Topico novoTopico, String idTopico) {
        try{
            var topicoIdentificado = listarTopicoEsperifico(idTopico);
            novoTopico.setIdTopico(idTopico); //Salvando o Id do antigo topico no novo
            novoTopico.setAutor(topicoIdentificado.getAutor()); //Salvando o autor que realizou o tópico no novo tópico
            topicoRepository.save(novoTopico);

        }catch (Exception e){
            throw new RuntimeException("Erro ao atualizar tópico: " + e.getMessage());
        }
    }
}
