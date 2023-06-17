package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio{
   @Autowired
   private ClienteRepository clienteRepository;
    public Cliente postCliente(Cliente cliente)throws Exception{
            return clienteRepository.save(cliente);
        }

    public Cliente getCliente(int id) throws Exception{
           Optional<Cliente> cliente= clienteRepository.findById(id);
                if(cliente.isEmpty()) {
                    return null;
                }else{ return cliente.get();
                }
        }
        public boolean clienteExiste (int id)throws Exception {
        Optional<Cliente> cliente=clienteRepository.findById(id);
        return cliente.isPresent();
        }
}