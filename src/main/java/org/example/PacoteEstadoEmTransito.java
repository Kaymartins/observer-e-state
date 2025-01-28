package org.example;

public class PacoteEstadoEmTransito extends PacoteEstado {

    private static PacoteEstadoEmTransito instance = new PacoteEstadoEmTransito();

    private PacoteEstadoEmTransito() {}

    public static PacoteEstadoEmTransito getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em trânsito";
    }

    public boolean entregar(Pacote pacote){
        pacote.setEstado(PacoteEstadoEntregue.getInstance());
        return true;
    }
}
