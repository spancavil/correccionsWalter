package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name="factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_factura;
    @ManyToOne
    //@JoinColumn(name ="id_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detalleFactura;
    private double total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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
    public String toString() {
        return "Factura{" +
                "id_factura=" + id_factura +
                ", cliente=" + cliente +
                ", detalleFactura=" + detalleFactura +
                ", total=" + total +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (id_factura != factura.id_factura) return false;
        if (Double.compare(factura.total, total) != 0) return false;
        if (!Objects.equals(cliente, factura.cliente)) return false;
        if (!Objects.equals(detalleFactura, factura.detalleFactura))
            return false;
        return Objects.equals(fecha, factura.fecha);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id_factura;
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (detalleFactura != null ? detalleFactura.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}





