package com.openwebinars.secondhandmarket.controladores;

import com.openwebinars.secondhandmarket.modelo.Usuario;
import com.openwebinars.secondhandmarket.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String welcome() {
        return "redirect:/public/";
    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute Usuario usuario) {
        usuarioServicio.registrar(usuario);
        return "redirect:/auth/login";
    }
}
