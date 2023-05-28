package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositoy extends JpaRepository<Factura,Integer>  {
}
