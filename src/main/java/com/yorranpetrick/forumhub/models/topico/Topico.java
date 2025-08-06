package com.yorranpetrick.forumhub.models.topico;


import com.yorranpetrick.forumhub.models.autor.Autor;
import jakarta.persistence.*;

@Table(name = "topico")
@Entity
public class Topico {
    @Column(name = "id")
    @Id
    private String idTopico;
    private String titulo;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "idAutor", referencedColumnName = "id")
    private Autor autor;

    public void setIdTopico(String idTopico) {
        this.idTopico = idTopico;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Autor getAutor() {
        return autor;
    }
}
