package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

@Entity
@Table(name="detallefactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;
    @ManyToOne
    @JoinColumn(name="id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
      private int cantidad;
    private double precio;
    //Agrego getter & Setters

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_detalle() {
        return precio;
    }

    public void setPrecio_detalle(double precio_detalle) {
        this.precio = precio_detalle;
    }


    //Agrego ToString

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id_detalle=" + id_detalle +
                ", factura=" + factura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precio_detalle=" + precio +
                '}';
    }
}
