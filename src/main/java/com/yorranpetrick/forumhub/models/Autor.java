package com.yorranpetrick.forumhub.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "autor")
@Entity
public class Autor {

    @Column(name = "id")
    @Id
    private String idAutor;
    private String nome;
    private String email;
    private String senha;

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
