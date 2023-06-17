package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Mapeo el EndPoint de producto
@RequestMapping(path="api/v1/producto")

public class ProductoControler {
@Autowired
private ProductoServicio productoServicio;

@PostMapping
public ResponseEntity<Object> postProducto(@RequestBody Producto producto) {
        try {
            System.out.println(producto);
            //LLamo al Servicio para guardar mi producto
             Producto productoSaved = productoServicio.postProducto(producto);
            return ResponseHandler.generateResponse(
                    "Producto creado correctamente",
                    HttpStatus.OK,
                    productoSaved);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);

}
}
}