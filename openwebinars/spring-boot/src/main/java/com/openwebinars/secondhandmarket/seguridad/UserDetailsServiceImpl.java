package com.openwebinars.secondhandmarket.seguridad;

import com.openwebinars.secondhandmarket.modelo.Usuario;
import com.openwebinars.secondhandmarket.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repositorio.findFirstByEmail(username);

        User.UserBuilder builder = null;

        if (usuario != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();

    }
}
