package com.marcelle.ForumHubChallenge.dominio.topico;

import com.marcelle.ForumHubChallenge.dominio.Usuario.Usuario;
import com.marcelle.ForumHubChallenge.dominio.curso.Curso;
import com.marcelle.ForumHubChallenge.dominio.resposta.Resposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Resposta> resposta;

    public Topico (DadosCriacaoTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDate.parse(dados.dataCriacao());
    }

    public void atualizarTopico(DadosAtualizarTopico dados){

        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }
}
