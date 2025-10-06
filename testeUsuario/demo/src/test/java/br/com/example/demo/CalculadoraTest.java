package br.com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.example.projeto.Calculadora;

public class CalculadoraTest {
    @Test
        public void SomaDoisNumeros() {
            Calculadora calculadora = new Calculadora();
            int soma = calculadora.soma(2, 3);
            System.out.println(soma);
            assertEquals(5, soma);
        }
}
