package com.coderhouse.Clase8.model;

import java.util.List;

public class FacturaDto {
    private int factura_id;
    private String creada_el;
    private double total;
    private List<DetalleFactura>detalleFacturas;
//Agrego un constructor

    public FacturaDto(int factura_id, String creada_el, double total) {
        this.factura_id = factura_id;
        this.creada_el = creada_el;
        this.total = total;
        this.detalleFacturas = detalleFacturas;
    }


    //Agrego Getter & Setters

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public String getCreada_el() {
        return creada_el;
    }

    public void setCreada_el(String creada_el) {
        this.creada_el = creada_el;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }


    //Agrego To String
    @Override
    public String toString() {
        return "FacturaDto{" +
                "factura_id=" + factura_id +
                ", creada_el='" + creada_el + '\'' +
                ", total=" + total +
                ", detalleFacturas=" + detalleFacturas +
                '}';
    }
}
