package com.coderhouse.Clase8.model;

import java.util.List;

public class FacturaConDetalleDto {
    private int factura_id;
    private String creada_el;
    private double total;
    private List<DetalleFacturaDto> detalles;

    public FacturaConDetalleDto(int factura_id, String creada_el, double total, List<DetalleFacturaDto> detalles) {
        this.factura_id = factura_id;
        this.creada_el = creada_el;
        this.total = total;
        this.detalles = detalles;
         }

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

    public List<DetalleFacturaDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaDto> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "FacturaConDetalleDto{" +
                "factura_id=" + factura_id +
                ", creada_el='" + creada_el + '\'' +
                ", total=" + total +
                ", detalles=" + detalles +
                '}';
    }
}
