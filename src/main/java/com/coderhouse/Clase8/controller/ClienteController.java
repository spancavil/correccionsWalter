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
public ResponseEntity<Object>postCliente(@RequestBody Cliente cliente) {
    try {
        System.out.println(cliente);
        //LLamo al Servicio para guardar mi cliente
        Cliente clienteSaved = clienteServicio.postCliente(cliente);
        return ResponseHandler.generateResponse(
                "Cliente creado correctamente",
                HttpStatus.OK,
                clienteSaved);

    } catch (Exception e) {
        return ResponseHandler.generateResponse
                (e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);



    }

}
//Modifico un Cliente creado
    @PutMapping(path = {"id"})

    public ResponseEntity<Object>putCliente(@PathVariable int id) {
        try {
            //LLamo al servicio para encontrar a ese cliente

            //LLamo al Servicio para guardar mi cliente
            Cliente clienteSaved = clienteServicio.putCliente(cliente);
            return ResponseHandler.generateResponse(
                    "Cliente actualizado correctamente",
                    HttpStatus.OK,
                    clienteSaved);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    (e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);


        }

    }


    //Solicito un  Cliente por Id
    @GetMapping(path = {"id"})
    public ResponseEntity<Object>GetCliente(@PathVariable int id) {
        try {
            System.out.println(id);
            //Conecto con el controlador con el Servicio.
            Cliente clienteEncontrado=clienteServicio.getCliente(id);
            return ResponseHandler.generateResponse (
                    "Cliente enviado correctamente",
                    HttpStatus.OK,
                    clienteEncontrado);

        } catch (Exception e) {
            return ResponseHandler.generateResponse
                    ( e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null);

        }
    }
}













