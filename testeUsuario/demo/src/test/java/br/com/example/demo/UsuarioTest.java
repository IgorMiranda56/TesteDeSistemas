package br.com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.example.projeto.Usuario;

public class UsuarioTest {
    @Test
    public void testCriarUsuarioValido(){
        Usuario usuario1 = new Usuario("Anderson");
        assertEquals("Anderson", usuario1.getNome());
    }

    @Test
    public void testCriarUsuarioInvalido(){
        Exception exception = assertThrows
        (IllegalArgumentException.class,
          () -> new Usuario(""));
        assertEquals("Nome inválido", exception.getMessage());
    }
}
