package br.com.example.demo;

import org.junit.jupiter.api.Test;

import br.com.example.projeto.Circulo;

public class TesteCirculo {
    @Test
        public void testeAreaCirculo() {
            Circulo circulo = new Circulo(5.0);
            double area = circulo.calcularArea();
            System.out.printf("Área do círculo: %.2f%n", area);
        }

    @Test
        public void testeCircunferenciaCirculo() {
            Circulo circulo = new Circulo(5.0);
            double circunferencia = circulo.calcularCircunferencia();
            System.out.printf("Circunferência do círculo: %.2f%n", circunferencia);
        }
    }
