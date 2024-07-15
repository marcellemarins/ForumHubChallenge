package com.marcelle.ForumHubChallenge.dominio.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT e FROM Usuario e where e.email ILIKE :email")
    List<Usuario> AcharPeloEmail(String email);

    UserDetails findByEmail(String email);
}
