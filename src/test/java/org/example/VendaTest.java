package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @Test
    public void testCriacaoVenda() {
        Venda venda = new Venda("Cliente 1");
        assertEquals("Cliente 1", venda.getCliente());
        assertEquals(Venda.SITUACAO_NAO_INICIADA, venda.getSituacao());
    }

    @Test
    public void testVenderItem() {
        Venda venda = new Venda("Cliente 2");
        venda.vender("Produto X", 10.0, 2.0);
        assertEquals(Venda.SITUACAO_EM_ANDAMENTO, venda.getSituacao());
        assertEquals(20.0, venda.getValor());
    }

    @Test
    public void testAplicarDescontoNaVenda() {
        Venda venda = new Venda("Cliente 3");
        venda.vender("Produto Y", 20.0, 3.0);
        assertTrue(venda.aplicarDesconto(10.0));
        assertEquals(54.0, venda.getValor()); // 60.0 - 10%
    }

    @Test
    public void testFinalizarVenda() {
        Venda venda = new Venda("Cliente 4");
        venda.vender("Produto Z", 30.0, 1.0);
        venda.finalizar();
        assertEquals(Venda.SITUACAO_ENCERRADA, venda.getSituacao());
    }

    @Test
    public void testFinalizarVendaNaoIniciada() {
        Venda venda = new Venda("Cliente 5");
        assertThrows(RuntimeException.class, venda::finalizar);
    }
}
