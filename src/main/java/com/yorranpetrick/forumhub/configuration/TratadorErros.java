package com.yorranpetrick.forumhub.configuration;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice //Anotação que indica que esta classe é um controlador de erros global
public class TratadorErros {

    @ExceptionHandler(EntityNotFoundException.class) // Anotação que indica que este método irá tratar exceções do tipo EntityNotFoundException
    public ResponseEntity tratarErro404() {
       return ResponseEntity.notFound().build(); // Retorna uma resposta 404 Not Found
    }
}
