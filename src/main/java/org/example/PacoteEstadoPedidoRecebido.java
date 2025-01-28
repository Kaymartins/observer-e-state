package org.example;

public class PacoteEstadoPedidoRecebido extends PacoteEstado {

    private static PacoteEstadoPedidoRecebido instance = new PacoteEstadoPedidoRecebido();

    private PacoteEstadoPedidoRecebido() {}

    public static PacoteEstadoPedidoRecebido getInstance() {
        return instance;
    }

    public String getEstado(){
        return "Pedido Recebido";
    }

    public boolean enviar(Pacote pacote){
        pacote.setEstado(PacoteEstadoEmTransito.getInstance());
        return true;
    }

    @Override
    public String toString() {
        return "Pedido Recebido"; // Retorna o texto esperado
    }
}
