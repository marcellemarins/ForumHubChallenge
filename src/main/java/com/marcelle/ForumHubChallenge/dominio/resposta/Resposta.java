package com.marcelle.ForumHubChallenge.dominio.resposta;

import com.marcelle.ForumHubChallenge.dominio.Usuario.Usuario;
import com.marcelle.ForumHubChallenge.dominio.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "respostas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDate dataCriacao;

    @ManyToOne
    private Topico topico;
    @ManyToOne
    private Usuario autor;
    private String solucao;
}
