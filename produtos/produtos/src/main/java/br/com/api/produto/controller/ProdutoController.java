package br.com.api.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produto.model.ProdutoModel;
import br.com.api.produto.model.RespostaModel;
import br.com.api.produto.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {
    @Autowired
    private ProdutoService ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody ProdutoModel pm){
        return ps.cadastrar(pm);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModel pm) {       
        return ps.cadastrarAlterar(pm, "alterar");
    }
    
    @GetMapping("/listar")
    public Iterable<ProdutoModel> listar() {
        return ps.listar();
    }
    
    @GetMapping("")
    public String rota() {
        return "api de produtos funcionando!";
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModel> remover(@PathVariable("id") Long id){
        return ps.remover(id);
    }

    
    
}
