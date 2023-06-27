package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id_cliente;
@Column(nullable = false)
 private String nombre;
 @Column(nullable = false)
 private String apellido;
 @Column(nullable = false,unique = true)
 private Integer documento;
 @OneToMany (mappedBy ="cliente",cascade = CascadeType.ALL)
 private List<Factura> facturas;

    // Agrego getter & Setters


  public int getId_cliente() {return id_cliente;}

   public void setId_cliente(int id_cliente) {this.id_cliente = id_cliente;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    //Agrego To string, Equals y Hashcode


    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento=" + documento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id_cliente != cliente.id_cliente) return false;
        if (!nombre.equals(cliente.nombre)) return false;
        if (!apellido.equals(cliente.apellido)) return false;
        return documento.equals(cliente.documento);
    }

    @Override
    public int hashCode() {
        int result = id_cliente;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        result = 31 * result + documento.hashCode();
        return result;
    }
}

