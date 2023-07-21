package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    private ClienteServicio clienteServicio;
   // private List<DetalleFactura> detalleFacturas;

    public FacturaDto postFactura(ConsultaFactura consultaFactura) throws Exception {
        //Busco al cliente atravez de si ID
        Cliente clinteExiste = clienteServicio.getCliente(consultaFactura.cliente_id);
        //Buscamos los productos
        List<Producto> productoList = productoServicio.getProductoById(consultaFactura.lista_producto);
       // Calculo del TOTAL
        double total = 0;
        int i = 0;
        for(Producto producto:productoList){
            total +=producto.getPrecio_producto() * consultaFactura.getLista_producto().get(i).getCantidad();
        i ++;
        }
        //Instanciamos un Objeto Factura
        Factura facturaCreada =new Factura();
        //Seteamos la fecha de la factura
        facturaCreada.setFecha(new Date().toString());
        //Seteamos al cliente dentro de la Factura
        facturaCreada.setCliente(clinteExiste);
        facturaCreada.setTotal((float) total);
        //Guardamos la Factura antes de guardar el Detalle
        facturaCreada=facturaRepository.save(facturaCreada);
        // Seteamos Cada Detalle y los guardamos
        i=0;
        for (Producto forDetalleProducto:productoList) {
            DetalleFactura nuevaFactura = new DetalleFactura();
            nuevaFactura.setPrecio_detalle(forDetalleProducto.getPrecio_producto());
            nuevaFactura.setFactura(facturaCreada);
            nuevaFactura.setProducto(forDetalleProducto);
            nuevaFactura.setCantidad(consultaFactura.getLista_producto().get(i).getCantidad());
            FacturaDetalleServicio.guardoDetalleFactura(nuevaFactura);
            i++;
        }
            // Retorno DTO
            return new FacturaDto(
                    facturaCreada.getId_factura(),
                    facturaCreada.getFecha(),
                    facturaCreada.getTotal()
            );
        }
        public List<FacturaDto> obtengoFacturaPorIdCliente (int id_cliente) throws Exception{
            System.out.println(id_cliente);
            return  facturaRepository.obtengoFacturaPorIdCliente(id_cliente);
        }
        public FacturaConDetalleDto obtegoFacturaPorId  (int id_factura) throws Exception {
        Optional<Factura> facturaEncontrada= facturaRepository.findById(id_factura);
        if (facturaEncontrada.isEmpty()) {
            throw new Exception("Factura no encontrada");
        }
       List<DetalleFacturaDto> detalles_factura =facturaDetalleServicio.getDetalleFacturaByFacturaId(id_factura);
            return new FacturaConDetalleDto(
                facturaEncontrada.get().getId_factura(),
                facturaEncontrada.get().getFecha(),
                facturaEncontrada.get().getTotal(),
                detalles_factura
        );
    }
}
