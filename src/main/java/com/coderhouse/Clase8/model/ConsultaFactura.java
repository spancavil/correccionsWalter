package com.coderhouse.Clase8.model;

import java.util.List;

public class ConsultaFactura {
    private int cliente_id;
    //luego se añaden los otros detalles aqui
    private List<ConsultaProductoDetalle> lista_producto;

    //Agrego un constructor

    public ConsultaFactura(int cliente_id,List<ConsultaProductoDetalle> lista_producto) {
        this.cliente_id = cliente_id;
        this.lista_producto = lista_producto;
    }


        }

