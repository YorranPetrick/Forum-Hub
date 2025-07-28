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
    private String id;
    private String nome;
    private String email;
    private String senha;

    public void setIdAutor(String id) {
        this.id = id;
    }

    public String getIdAutor() {
        return id;
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
