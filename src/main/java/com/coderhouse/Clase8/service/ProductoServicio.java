package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.ConsultaProductoDetalle;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto postProducto(Producto producto) throws Exception {
        return productoRepository.save(producto);
    }


    public List<Producto> getProductoById(List<ConsultaProductoDetalle> productoListId) throws Exception {
        List<Producto> listaProducto = new ArrayList<>();
        for (ConsultaProductoDetalle consultoproducto :
                productoListId) {
            Optional<Producto> productoEncontrado = ProductoRepository.findById(consultoproducto.getProductoId());
            if (productoEncontrado.isEmpty()) {
                throw new Exception("Producto con Id" + consultoproducto.getProductoId() + "NO ENCONTRADO");
            }
            listaProducto.add(productoEncontrado.get());
        }
        return listaProducto;
    }

    public void actualizoProducto(Producto producto, int id) throws Exception {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isEmpty()) {
            throw new Exception("Producto INEXISTENTE");
        } else {
            productoExistente.get().setTitulo(producto.getTitulo());
            productoExistente.get().setDescripcion(producto.getDescripcion());
            productoExistente.get().setCodigo(producto.getCodigo());
            productoExistente.get().setPrecio_producto(producto.getPrecio_producto());
            //Se conecta al repositorio de Producto para guardarlo
            productoRepository.save(productoExistente.get());
        }
    }

        public void borroProducto ( int idProducto)throws Exception {
            Optional<Producto> productoExistente = productoRepository.findById(idProducto);
            if (productoExistente.isEmpty()) {
                throw new Exception("Producto INEXISTENTE");
            } else {
                   //Se conecta al repositorio de Producto para Borrarlo no estoy seguro si esta opcion es la que va
                productoRepository.deleteAll(productoExistente.get());
            }
        }
    }

