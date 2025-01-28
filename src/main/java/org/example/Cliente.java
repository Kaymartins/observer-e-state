package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getUltimaNotificacao(){
        return ultimaNotificacao;
    }

    public void rastrearPacote(Pacote pacote){
        pacote.addObserver(this);
    }

    public void update(Observable pacote, Object arg){
        this.ultimaNotificacao = nome + ", atualização do pacote: " + ((Pacote) pacote).getEstado().getEstado();
        System.out.println(this.ultimaNotificacao);
    }
}
