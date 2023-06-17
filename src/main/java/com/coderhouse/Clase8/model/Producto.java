package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

import java.util.*;
import java.util.Objects;

@Entity
@Table(name="producto")
public class Producto implements List<Producto> {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_producto;
@Column(nullable = false)
private String titulo;
@Column(nullable = false)
private String descripcion;
@Column(nullable = false)
private String codigo;
@Column(nullable = false)
private int stock;
@Column(nullable = false)
private double precio_producto;


    // Agrego getter & Setters

  public int getId_producto() {return id_producto; }

    public void setId_producto(int id_producto) {this.id_producto = id_producto;}

    public String getDescripcion() {return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }


    public String getCodigo() { return codigo;}


    public void setCodigo(String codigo) {this.codigo = codigo; }

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock; }

    public double getPrecio_producto() {return precio_producto;}

    public void setPrecio_producto(double precio_producto)
    {this.precio_producto = precio_producto; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //Agrego To string, Equals y Hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        if (id_producto != producto.id_producto) return false;
        if (stock != producto.stock) return false;
        if (Double.compare(producto.precio_producto, precio_producto) != 0) return false;
        if (!titulo.equals(producto.titulo)) return false;
        if (!descripcion.equals(producto.descripcion)) return false;
        return codigo.equals(producto.codigo);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id_producto;
        result = 31 * result + titulo.hashCode();
        result = 31 * result + descripcion.hashCode();
        result = 31 * result + codigo.hashCode();
        result = 31 * result + stock;
        temp = Double.doubleToLongBits(precio_producto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", stock=" + stock +
                ", precio_producto=" + precio_producto +
                '}';
    }
}

