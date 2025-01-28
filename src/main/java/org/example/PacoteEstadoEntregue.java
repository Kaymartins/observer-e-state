package org.example;

public class PacoteEstadoEntregue extends PacoteEstado{

    private static PacoteEstadoEntregue instance = new PacoteEstadoEntregue();

    private PacoteEstadoEntregue() {}

    public static PacoteEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado(){
        return "Entregue";
    }

}
