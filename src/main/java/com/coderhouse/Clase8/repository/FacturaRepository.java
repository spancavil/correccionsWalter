package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Factura;

import com.coderhouse.Clase8.model.FacturaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura,Integer>  {
    //En JPQL Se hace un INNER JOIN entre el Id del Cliente y sus Facturas y se guardan en una DTO
    @Query("SELECT new com.coderhouse.Clase8.model.FacturaDto("+
    "f.id id_factura,"+
    "f.creada_el,"+
    "f.total"+
    ")FROM Factura f INNER JOIN f.cliente c WHERE C.id=:id")
     List<FacturaDto> obtengoFacturaPorIdCliente(@Param("id") int id);
    }

