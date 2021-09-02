package com.openwebinars.secondhandmarket.controladores;

import com.openwebinars.secondhandmarket.modelo.Producto;
import com.openwebinars.secondhandmarket.modelo.Usuario;
import com.openwebinars.secondhandmarket.servicios.ProductoServicio;
import com.openwebinars.secondhandmarket.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/app")
public class ProductosController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    private Usuario usuario;

    @ModelAttribute("misproductos")
    public List<Producto> misProductos() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        usuario = usuarioServicio.buscarPorEmail(email);
        return productoServicio.productosDeUnPropietario(usuario);
    }

    @GetMapping("/misproductos")
    public String list(Model model, @RequestParam(name = "q", required = false) String query) {
        if (query != null)
            model.addAttribute("misproductos", productoServicio.buscarMisProductos(query, usuario));

        return "app/producto/lista";
    }

    @GetMapping("/misproductos/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        Producto p = productoServicio.findById(id);
        if (p.getCompra() == null)
            productoServicio.borrar(p);
        return "redirect:/app/misproductos";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "app/producto/form";
    }

    @PostMapping("/producto/nuevo/submit")
    public String nuevoProductoSubmit(@ModelAttribute Producto producto) {
        producto.setPropietario(usuario);
        productoServicio.insertar(producto);
        return "redirect:/app/misproductos";
    }

}
