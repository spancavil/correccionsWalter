package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_factura;
    @ManyToOne
    @JoinColumn(name ="id_cliente")

    private Cliente cliente;
    private int id_cliente_factura;
    private float total;
    private String fecha;


 //Agrego Getters y Setters

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId_cliente_factura() {
        return id_cliente_factura;
    }

    public void setId_cliente_factura(int id_cliente_factura) {
        this.id_cliente_factura = id_cliente_factura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


// Agrego To String Equals y HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (id_factura != factura.id_factura) return false;
        if (id_cliente_factura != factura.id_cliente_factura) return false;
        if (Float.compare(factura.total, total) != 0) return false;
        if (!cliente.equals(factura.cliente)) return false;
        return Objects.equals(fecha, factura.fecha);
    }

    @Override
    public int hashCode() {
        int result = id_factura;
        result = 31 * result + cliente.hashCode();
        result = 31 * result + id_cliente_factura;
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id_factura=" + id_factura +
                ", cliente=" + cliente +
                ", id_cliente_factura=" + id_cliente_factura +
                ", total=" + total +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}

