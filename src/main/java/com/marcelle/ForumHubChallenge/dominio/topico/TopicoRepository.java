package com.marcelle.ForumHubChallenge.dominio.topico;

import com.marcelle.ForumHubChallenge.dominio.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT a FROM Topico t JOIN t.autor a WHERE a.email ILIKE :email")
    Optional<Usuario> autorDoTopico(String email);
}
