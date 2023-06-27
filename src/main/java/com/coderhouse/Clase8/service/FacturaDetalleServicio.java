package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.DetalleFactura;
import com.coderhouse.Clase8.model.DetalleFacturaDto;
import com.coderhouse.Clase8.repository.FacturaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaDetalleServicio {
    @Autowired
    private static FacturaDetalleRepository facturaDetalleRepository;
    public static void guardoDetalleFactura(DetalleFactura detalleFactura)throws Exception{
        facturaDetalleRepository.save(detalleFactura);
      }
     public List<DetalleFacturaDto> getDetalleFacturaByFacturaId (int factura_id)throws  Exception{
        return facturaDetalleRepository.getDetalleFacturaByFacturaId(factura_id);
     }
}
