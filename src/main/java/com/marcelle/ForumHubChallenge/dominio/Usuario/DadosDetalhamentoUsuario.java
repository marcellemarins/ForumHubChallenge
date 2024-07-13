package com.marcelle.ForumHubChallenge.dominio.Usuario;

public record DadosDetalhamentoUsuario(String nome, String email) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail());
    }
}
