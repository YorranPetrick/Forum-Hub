package com.yorranpetrick.forumhub.models.autor;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "autor")
@Entity
public class Autor implements UserDetails {

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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TiposAutores getTipoUsuario() {return tipoUsuario;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + tipoUsuario.toString()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }
}
