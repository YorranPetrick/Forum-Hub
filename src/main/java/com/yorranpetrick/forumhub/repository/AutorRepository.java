package com.yorranpetrick.forumhub.repository;

import com.yorranpetrick.forumhub.models.Autor;
import com.yorranpetrick.forumhub.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, String> {

}
