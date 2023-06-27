package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.DetalleFactura;
import com.coderhouse.Clase8.model.DetalleFacturaDto;
import com.coderhouse.Clase8.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaDetalleRepository extends JpaRepository<DetalleFactura,Integer> {
    @Query("SELECT new com.coderhouse.Clase8.model.DetalleFacturaDto("+
    "p.titulo," +
    "p.descripcion," +
    "p.codigo," +
    "d.precio," +
    "d.cantidad" +
    ") FROM Factura i JOIN i.detalleFactura d JOIN d.producto p WHERE i.id = :id")
    List<DetalleFacturaDto> getDetalleFacturaByFacturaId(@Param("id")int factura_id );
}

