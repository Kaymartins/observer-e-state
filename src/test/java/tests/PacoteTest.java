package tests;

import org.example.Cliente;
import org.example.Pacote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacoteTest {
    Pacote pacote;
    Cliente cliente;

    @BeforeEach
    public void setUp() {
        pacote = new Pacote("PKG123");
        cliente = new Cliente("Maria");
        cliente.rastrearPacote(pacote);
        assertNotNull(pacote, "Pacote nao deve ser nulo apos inicialização");
    }

    @Test
    public void deveIniciarComEstadoPedidoRecebido() {
        Pacote pacote = new Pacote("PKG123");
        String estadoEsperado = "Pedido Recebido";
        assertEquals(estadoEsperado, pacote.getEstado().getEstado());
    }

    @Test
    public void deveMudarParaEmTransitoENotificarCliente() {
        boolean sucesso = pacote.enviar();
        assertTrue(sucesso);
        assertEquals("Em trânsito", pacote.getEstado().getEstado());
        assertEquals("Maria, atualização do pacote: Em trânsito", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveMudarParaEntregueENotificarCliente() {
        pacote.enviar();
        boolean sucesso = pacote.entregar();
        assertTrue(sucesso);
        assertEquals("Maria, atualização do pacote: Entregue", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveFalharAoEntregarPacoteNaoEnviado(){
        boolean sucesso = pacote.entregar();
        assertFalse(sucesso);
        assertEquals("Pedido Recebido", pacote.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao()); // Nenhuma notificação foi enviada
    }

    @Test
    public void deveNotificarTodosClientes(){
        Cliente cliente2 = new Cliente("Carlos");

        cliente2.rastrearPacote(pacote);
        pacote.enviar();

        assertEquals("Carlos, atualização do pacote: Em trânsito", cliente2.getUltimaNotificacao());
        assertEquals("Maria, atualização do pacote: Em trânsito", cliente.getUltimaNotificacao());
    }



}
