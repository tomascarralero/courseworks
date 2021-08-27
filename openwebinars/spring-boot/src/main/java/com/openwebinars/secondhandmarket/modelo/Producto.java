package com.openwebinars.secondhandmarket.modelo;

import javax.persistence.*;

@Entity
public class Producto {

    @Id @GeneratedValue
    private long id;

    private String nombre;

    private String precio;

    private String imagen;

    @ManyToOne
    private Usuario propietario;

    @ManyToOne
    private Compra compra;

    public Producto() { }

    public Producto(String nombre, String precio, String imagen, Usuario propietario) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.propietario = propietario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        if (id != producto.id) return false;
        if (nombre != null ? !nombre.equals(producto.nombre) : producto.nombre != null) return false;
        if (precio != null ? !precio.equals(producto.precio) : producto.precio != null) return false;
        if (imagen != null ? !imagen.equals(producto.imagen) : producto.imagen != null) return false;
        if (propietario != null ? !propietario.equals(producto.propietario) : producto.propietario != null)
            return false;
        return compra != null ? compra.equals(producto.compra) : producto.compra == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (imagen != null ? imagen.hashCode() : 0);
        result = 31 * result + (propietario != null ? propietario.hashCode() : 0);
        result = 31 * result + (compra != null ? compra.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", imagen='" + imagen + '\'' +
                ", propietario=" + propietario +
                ", compra=" + compra +
                '}';
    }
}
