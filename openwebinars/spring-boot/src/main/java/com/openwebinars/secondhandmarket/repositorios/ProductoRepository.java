package com.openwebinars.secondhandmarket.repositorios;

import com.openwebinars.secondhandmarket.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
