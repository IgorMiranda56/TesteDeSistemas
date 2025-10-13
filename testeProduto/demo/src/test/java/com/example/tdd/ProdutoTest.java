package com.example.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ProdutoTest {
    @Test
    public void testProdutoValido(){
        Produto p = new Produto("Notebook", 3500.00);
        assertEquals("Notebook", p.getNome());
        assertEquals(3500.00, p.getPreco(), 0.001);
    }   
    
    @Test
    public void testNomeInvalido(){
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("", 1000));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    public void testPrecoInvalido(){
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Mouse", 0));
        assertEquals("Preço inválido", e.getMessage());
    }
}


