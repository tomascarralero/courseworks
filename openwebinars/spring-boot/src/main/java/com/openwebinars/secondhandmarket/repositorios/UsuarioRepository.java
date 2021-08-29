package com.openwebinars.secondhandmarket.repositorios;

import com.openwebinars.secondhandmarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findFirstByEmail(String email);
}
