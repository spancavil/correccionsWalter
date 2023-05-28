package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.model.ConsultaFactura;
import com.coderhouse.Clase8.model.Factura;
import com.coderhouse.Clase8.model.FacturaDto;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.repository.FacturaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    private FacturaRepositoy facturaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    public FacturaDto postFactura (ConsultaFactura consultaFactura) throws Exception{
        //Creo un objeto Factura
        Factura facturaCreada=new Factura();
        //Seteo fecha de la Factura
        facturaCreada.setFecha (new Date().toString());
        //Se imprime el Id de Cliente
        System.out.println(consultaFactura.getCliente_id());
        //Busco al Cliente por su Id
        Optional<Cliente>clienteExiste=clienteRepository.findById(consultaFactura.getCliente_id());
        System.out.println(clienteExiste.isEmpty());
        if(clienteExiste.isEmpty()){
            throw new Exception("Cliente no encontrado...");
        }
        //Si llego aca, el cliente existe, entonces se guarda en la Factura
        facturaCreada.setCliente(clienteExiste.get());
        //Conectamos con el Repository para guardar las variables seteadas
        facturaCreada=facturaRepository.save(facturaCreada);
        //Retornamos el DTO
        return new FacturaDto(
                facturaCreada.getId_factura(),
                facturaCreada.getFecha(),
                facturaCreada.getTotal()
        );
    }
}
