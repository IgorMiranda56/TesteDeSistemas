package br.com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.example.projeto.Retangulo;

public class RetanguloTest {
    @Test
    public void TesteCalcularArea() {
        Retangulo retangulo = new Retangulo(5, 10);
        int area = retangulo.calcularArea();
        System.out.println(area);
        assertEquals(50, area);
    }
    @Test
    public void TesteCalcularPerimetro() {
        Retangulo retangulo = new Retangulo(5, 10);
        int perimetro = retangulo.calcularPerimetro(5, 10);
        System.out.println(perimetro);
        assertEquals(30, perimetro);
    }
    
}
