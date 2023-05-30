package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServicio {
@Autowired
private ProductoRepository productoRepository;
public Producto postProducto(Producto producto)throws Exception{
        return productoRepository.save(producto);
    }
public Producto getProducto(int id) throws Exception{
        Optional<Producto> producto= productoRepository.findById(id);
        if(producto.isEmpty()) {
            return null;
        }else{ return producto.get();
        }
    }

}
