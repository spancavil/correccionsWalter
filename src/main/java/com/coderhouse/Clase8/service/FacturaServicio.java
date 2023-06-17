package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    private ClienteServicio clienteServicio;

    public FacturaDto postFactura(ConsultaFactura consultaFactura) throws Exception {
        //Busco al cliente atravez de si ID
        Cliente clinteExiste = clienteServicio.getCliente(consultaFactura.getclienteId());
        //Buscamos los productos
        List<Producto> productoList = productoServicio.getProductobyid(consultaFactura.getproductoLista());

    }

        //Creo un objeto Factura
        // Factura facturaCreada=new Factura();
        //Seteo fecha de la Factura
        // facturaCreada.setFecha (new Date().toString());
        //Se imprime el Id de Cliente
        //System.out.println(consultaFactura.getCliente_id());
        //Busco al Cliente por su Id
        //Optional<Cliente>clienteExiste=clienteRepository.findById(consultaFactura.getCliente_id());
        //System.out.println(clienteExiste.isEmpty());
        //if(clienteExiste.isEmpty()){
        //  throw new Exception("Cliente no encontrado...");
        //}
        //Si llego aca, el cliente existe, entonces se guarda en la Factura
        // facturaCreada.setCliente(clienteExiste.get());
        //Conectamos con el Repository para guardar las variables seteadas
        //  facturaCreada=facturaRepository.save(facturaCreada);
        //Retornamos el DTO
        // return new FacturaDto(
        //        facturaCreada.getId_factura(),
        //       facturaCreada.getFecha(),
        //        facturaCreada.getTotal()
        // );
        //}
        // public List<FacturaDto>obtengoFacturaPorIdCliente(int id_cliente) throws Exception{
        //     System.out.println(id_cliente);
        //    return FacturaRepository.obtengoFacturaPorIdCliente(id_cliente);
        //}
    }
