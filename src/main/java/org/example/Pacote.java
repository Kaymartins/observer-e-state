package org.example;

import java.util.Observable;

public class Pacote extends Observable {

    private String codigo;
    private PacoteEstado estado;

    public Pacote(String codigo){
        this.codigo = codigo;
        this.estado = PacoteEstadoPedidoRecebido.getInstance();
    }

    public boolean enviar(){
        return estado.enviar(this);
    }

    public boolean entregar(){
        return estado.entregar(this);
    }

    public void setEstado(PacoteEstado estado){
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public PacoteEstado getEstado(){
        return estado;
    }
}
