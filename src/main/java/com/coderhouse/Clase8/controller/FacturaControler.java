package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.ConsultaFactura;
import com.coderhouse.Clase8.model.FacturaDto;
import com.coderhouse.Clase8.service.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Mapeo el endPoint de Factura
@RequestMapping(path ="api/v1/factura")
public class FacturaControler {
    @Autowired
    private FacturaServicio facturaServcio;

    @PostMapping
    public ResponseEntity<Object> postFactura(@RequestBody ConsultaFactura facturacreada) {
        try {
            System.out.println(facturacreada);
            //LLamo al Servicio que genera la factura creada en el Data Transfer Object(DTO)
            FacturaDto dato = facturaServcio.postFactura(facturacreada);
            return ResponseHandler.generateResponse(
                    "Factura creada correctamente",
                    HttpStatus.OK,
                    dato);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);
        }

    }
}