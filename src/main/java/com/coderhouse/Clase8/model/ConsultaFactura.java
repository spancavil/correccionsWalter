package com.coderhouse.Clase8.model;

import java.util.List;

public class ConsultaFactura {
    public int cliente_id;
    //luego se añaden los otros detalles aqui
    public List<ConsultaProductoDetalle> lista_producto;

    //Agrego un constructor

    public ConsultaFactura(int cliente_id,List<ConsultaProductoDetalle> lista_producto) {
        this.cliente_id = cliente_id;
        this.lista_producto = lista_producto;
    }
    //Agrego Getter & Setters


    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<ConsultaProductoDetalle> getLista_producto() {
        return lista_producto;
    }

    public void setLista_producto(List<ConsultaProductoDetalle> lista_producto) {
        this.lista_producto = lista_producto;
    }
}

