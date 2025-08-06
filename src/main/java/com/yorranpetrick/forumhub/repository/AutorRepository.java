package com.yorranpetrick.forumhub.repository;

import com.yorranpetrick.forumhub.models.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, String> {

    @Override
    List<Autor> findAll();
}
