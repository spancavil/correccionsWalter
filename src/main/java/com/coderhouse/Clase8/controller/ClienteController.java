package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.middleware.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coderhouse.Clase8.service.ClienteServicio;

@RestController
//Mapeo el EndPoint de Cliente
@RequestMapping(path="api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteServicio clienteServicio;

    //CRUD de Cliente
//Creo Cliente
    @PostMapping
    public ResponseEntity<Object> postCliente(@RequestBody Cliente cliente) {
        try {
            System.out.println(cliente);
            //LLamo al Servicio para guardar mi cliente
            Cliente clienteGuardado = clienteServicio.postCliente(cliente);
            return ResponseHandler.generateResponse(
                    "Cliente creado correctamente",
                    HttpStatus.OK,
                    clienteGuardado);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);
        }
    }

    //Solicito un  Cliente por Id
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getCliente(@PathVariable() int id) {
        try {
            System.out.println(id);
            //Conecto con el controlador con el Servicio.
            Cliente clienteEncontrado = clienteServicio.getCliente(id);
            return ResponseHandler.generateResponse(
                    "Cliente enviado correctamente",
                    HttpStatus.OK,
                    clienteEncontrado);
        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null
                    );
        }
    }

//Modifico un Cliente creado
        @PutMapping (path = "{id}")
        public ResponseEntity<Object> putCliente ( @PathVariable("id") int id, @RequestBody Cliente cliente){
            try {
                System.out.println(cliente);
                System.out.println(id);
                clienteServicio.actualizoCliente(cliente, id);
                return ResponseHandler.generateResponse(
                        "Cliente modificado Correctamente",
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
        //Baja de un Cliente creado
        @DeleteMapping(path = "{id_cliente}")
        public ResponseEntity<Object> borroCliente ( @PathVariable() int id_cliente){
            try {
                System.out.println(id_cliente);
                //Conecto el controlador con el Servicio.
                clienteServicio.borroCliente(id_cliente);
                return ResponseHandler.generateResponse(
                        "Cliente eliminado correctamente",
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




