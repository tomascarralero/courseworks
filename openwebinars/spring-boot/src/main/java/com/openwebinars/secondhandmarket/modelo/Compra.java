package com.openwebinars.secondhandmarket.modelo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Compra {

    @Id @GeneratedValue
    private long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @ManyToOne
    private Usuario propietario;

    public Compra() { }

    public Compra(Usuario propietario) {
        this.propietario = propietario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compra compra = (Compra) o;

        if (id != compra.id) return false;
        if (fechaCompra != null ? !fechaCompra.equals(compra.fechaCompra) : compra.fechaCompra != null) return false;
        return propietario != null ? propietario.equals(compra.propietario) : compra.propietario == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fechaCompra != null ? fechaCompra.hashCode() : 0);
        result = 31 * result + (propietario != null ? propietario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fechaCompra=" + fechaCompra +
                ", propietario=" + propietario +
                '}';
    }
}
