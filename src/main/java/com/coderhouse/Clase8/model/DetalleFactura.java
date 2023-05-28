package com.coderhouse.Clase8.model;

import jakarta.persistence.*;

@Entity
@Table(name="detallefactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;
    private int id_factura_detalle;
    private int id_producto_detalle;
    private int cantidad;
    private double precio_detalle;


}
