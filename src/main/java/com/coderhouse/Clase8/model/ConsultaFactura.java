package com.coderhouse.Clase8.model;

public class ConsultaFactura {
    private int cliente_id;
    //luego se añaden los otros detalles aqui
    private String otra_prop;

    //Agrego un constructor

    public ConsultaFactura(int cliente_id, String otra_prop) {
        this.cliente_id = cliente_id;
        this.otra_prop = otra_prop;
    }
    //Agrego Getter & Setters
    public int getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    public String getOtra_prop() {
        return otra_prop;
    }
    public void setOtra_prop(String otra_prop) {
        this.otra_prop = otra_prop;
    }
    //Agrego toString

    @Override
    public String toString() {
        return "ConsultaFactura{" +
                "cliente_id=" + cliente_id +
                ", otra_prop='" + otra_prop + '\'' +
                '}';
    }
}
