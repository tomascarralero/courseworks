package com.openwebinars.secondhandmarket.servicios;

import com.openwebinars.secondhandmarket.modelo.Producto;
import com.openwebinars.secondhandmarket.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepository repositorio;

    public Producto insertar(Producto p) {
        return repositorio.save(p);
    }

    public void borrar(long id) {
        repositorio.deleteById(id);
    }

    public void borrar(Producto p) {
        repositorio.delete(p);
    }

    public Producto editar(Producto p) {
        return repositorio.save(p);
    }

    public Producto findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Producto> findAll() {
        return repositorio.findAll();
    }
}
