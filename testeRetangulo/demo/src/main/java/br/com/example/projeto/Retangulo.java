package br.com.example.projeto;

public class Retangulo {
    private int base;
    private int altura;    

    public Retangulo(int base, int Altura){
        this.base = base;
        this.altura = Altura;
    }

    public int calcularArea(){
        return base * altura;
    }

    public int calcularPerimetro(int i, int j){
        return 2 * base + 2 * altura;
    }
}
