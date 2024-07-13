package com.marcelle.ForumHubChallenge.dominio.Usuario;

public record DadosListarUsuario(String nome, String email) {
    public DadosListarUsuario(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail());
    }
}
