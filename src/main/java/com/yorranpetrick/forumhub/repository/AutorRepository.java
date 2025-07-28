package com.yorranpetrick.forumhub.repository;

import com.yorranpetrick.forumhub.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, String> {
}
