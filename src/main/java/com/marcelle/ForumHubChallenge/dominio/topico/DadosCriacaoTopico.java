package com.marcelle.ForumHubChallenge.dominio.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCriacaoTopico(@NotBlank
                                 String titulo,
                                 @NotBlank
                                 String mensagem,
                                 @NotBlank
                                 String dataCriacao,
                                 @NotBlank
                                 String login

) {
}
