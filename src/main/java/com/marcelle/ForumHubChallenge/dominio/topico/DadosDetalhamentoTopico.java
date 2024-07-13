package com.marcelle.ForumHubChallenge.dominio.topico;

public record DadosDetalhamentoTopico(String titulo, String mensagem) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem());
    }
}