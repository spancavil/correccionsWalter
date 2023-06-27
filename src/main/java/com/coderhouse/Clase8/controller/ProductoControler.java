package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
             Producto productoGuardado = productoServicio.postProducto(producto);
            return ResponseHandler.generateResponse(
                    "Producto creado correctamente",
                    HttpStatus.OK,
                    productoGuardado);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);

                }
        }

    //Solicito un  Producto por Id
    @GetMapping(path = {"id"})
    public ResponseEntity<Object> getProducto(@PathVariable() List id) {
        try {
            System.out.println(id);
            //Conecto con el controlador con el Servicio.
            List<Producto> productoEncontrado = productoServicio.getProductoById(id);
            return ResponseHandler.generateResponse(
                    "Producto enviado correctamente",
                    HttpStatus.OK,
                    productoEncontrado);
        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null
                    );
        }
    }

    //Modifico un Producto creado
    @PutMapping (path = "{id}")
    public ResponseEntity<Object> putProducto ( @PathVariable("id") int id, @RequestBody  Producto producto){
        try {
            System.out.println(producto);
            System.out.println(id);
           productoServicio.actualizoProducto(producto, id);
            return ResponseHandler.generateResponse(
                    "Producto modificado Correctamente",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);


        }

    }
    //Baja de un Producto creado
    @DeleteMapping(path = "{id_producto}")
    public ResponseEntity<Object> borroProducto ( @PathVariable() int id_producto){
        try {
            System.out.println(id_producto);
            //Conecto el controlador con el Servicio.
            productoServicio.borroProducto(id_producto);
            return ResponseHandler.generateResponse(
                    "Producto eliminado correctamente",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);
        }
    }


}