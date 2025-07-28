package com.yorranpetrick.forumhub.repository;

import com.yorranpetrick.forumhub.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, String> {

    public List<Topico> findAllByAutorId(String idAutor); // Método para buscar todos os tópicos por ID do autor

}
