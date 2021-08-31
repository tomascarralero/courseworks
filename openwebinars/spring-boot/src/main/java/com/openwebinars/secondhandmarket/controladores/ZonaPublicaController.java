package com.openwebinars.secondhandmarket.controladores;

import com.openwebinars.secondhandmarket.modelo.Producto;
import com.openwebinars.secondhandmarket.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/public")
public class ZonaPublicaController {

    @Autowired
    ProductoServicio productoServicio;

    @ModelAttribute
    public List<Producto> productosNoVendidos() {
        return productoServicio.losProductosSinVender();
    }

    @GetMapping({"/", "/index"})
    public String index(Model model, @RequestParam(name="q", required=false) String query) {
        if (query != null) {
            model.addAttribute("productos", productoServicio.buscar(query));
        }
        return "index";
    }

    @GetMapping("/producto/{id}")
    public String showProduct(Model modelo, @PathVariable Long id) {
        Producto result = productoServicio.findById(id);
        if (result != null) {
            modelo.addAttribute("producto", result);
        }
        return "redirect:/public";
    }

}
