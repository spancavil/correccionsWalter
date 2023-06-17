package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.DetalleFactura;
import com.coderhouse.Clase8.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleRepository extends JpaRepository<DetalleFactura,Integer> {}

