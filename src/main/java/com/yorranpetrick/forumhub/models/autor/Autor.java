package com.yorranpetrick.forumhub.models.autor;


import jakarta.persistence.*;

@Table(name = "autor")
@Entity
public class Autor {

    @Column(name = "id")
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TiposAutores tipoUsuario;

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

    public TiposAutores getTipoUsuario() {return tipoUsuario;}
}
