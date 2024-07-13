package com.marcelle.ForumHubChallenge.dominio.topico;

import com.marcelle.ForumHubChallenge.dominio.Usuario.Usuario;

import java.time.LocalDate;

public record DadosListarTopico(String titulo, String Mensagem, LocalDate dataCriacao, Status status, Usuario autor) {

    public DadosListarTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor());
    }
}
