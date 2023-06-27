package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente postCliente(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    public Cliente getCliente(int clienteId) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isEmpty()) {
            return null;
        } else {
            return cliente.get();
        }
    }

    public void actualizoCliente(Cliente cliente, int id) throws Exception {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isEmpty()) {
            throw new Exception("Cliente INEXISTENTE");
        } else {
            clienteExistente.get().setDocumento(cliente.getDocumento());
            clienteExistente.get().setNombre(cliente.getNombre());
            clienteExistente.get().setApellido(cliente.getApellido());
            // Se conecta con el repositorio de Servicio para guardarlo
            clienteRepository.save(clienteExistente.get());
        }
    }

    public Cliente borroCliente(int id) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Cliente INEXISTENTE");
        } else {
            //Se conecta al repositorio de Clienete para borrarlo
            clienteRepository.deleteById(id);
        }
        return null;
    }
    public boolean clienteExiste ( int id)throws Exception {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.isPresent();
        }
    }



