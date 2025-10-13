package com.example.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void testSomar(){
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    public void testSubtrair(){
        Calculadora calc = new Calculadora();
        int resultado = calc.subtrair(10, 4);
        assertEquals(6, resultado);
    }

    @Test
    public void testMultiplicar(){
        Calculadora calc = new Calculadora();
        int resultado = calc.multiplicar(3 ,7);
        assertEquals(21, resultado);
    }

    @Test
    public void testDividir(){
        Calculadora calc = new Calculadora();
        int resultado = calc.dividir(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividirPorZero(){
        Calculadora calc = new Calculadora();
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> calc.dividir(10, 0));
        assertEquals("Não é possível dividir por zero.", e.getMessage());
    }
}
