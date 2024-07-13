package com.marcelle.ForumHubChallenge.dominio.Usuario;

import com.marcelle.ForumHubChallenge.dominio.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topico;

    public Usuario(DadosCriacaoUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email().toLowerCase();
        this.senha = dados.senha();
    }

    public void atualizacaoUsuario(DadosAtualizacaoUsuario dados){

        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.senha() != null){
            this.senha = dados.senha();
        }

    }



    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopico(List<Topico> topico) {
        this.topico = topico;
    }
}