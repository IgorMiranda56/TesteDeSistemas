package br.com.api.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produto.model.ProdutoModel;
import br.com.api.produto.model.RespostaModel;
import br.com.api.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository pr;

    @Autowired
    private RespostaModel rm;

    //Método para listar os produtos.
    public Iterable<ProdutoModel> listar(){
        return pr.findAll();
    }

    //Método para cadastrar os produtos ou alterar os produtos.
    public ResponseEntity<?> cadastrarAlterar(ProdutoModel pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório.");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório.");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);
            }else{
            return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);
        }
    }
}

    //Método para cadastrar os produtos.
    public ResponseEntity<?> cadastrar(ProdutoModel pm){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório.");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório.");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);
        }
    }

    //Método para remover produtos.
    public ResponseEntity<RespostaModel> remover(Long id){
        pr.deleteById(id);
        rm.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModel>(rm, HttpStatus.OK);
    }
}
