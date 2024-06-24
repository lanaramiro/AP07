package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testCriacaoItem() {
        Item item = new Item("Produto A", 2.0, 10.0);
        assertEquals("Produto A", item.getProduto());
        assertEquals(2.0, item.getQuantidade());
        assertEquals(10.0, item.getPrecoUnitario());
    }

    @Test
    public void testValorUnitario() {
        Item item = new Item("Produto B", 3.0, 20.0);
        assertEquals(60.0, item.getValorUnitario());
    }

    @Test
    public void testAplicarDescontoDentroDoLimite() {
        Item item = new Item("Produto C", 5.0, 10.0);
        assertTrue(item.aplicarDesconto(50.0));
        assertEquals(5.0, item.getPrecoUnitario());
    }

    @Test
    public void testAplicarDescontoForaDoLimite() {
        Item item = new Item("Produto D", 1.0, 100.0);
        assertFalse(item.aplicarDesconto(80.0));
        assertEquals(100.0, item.getPrecoUnitario());
    }
}

