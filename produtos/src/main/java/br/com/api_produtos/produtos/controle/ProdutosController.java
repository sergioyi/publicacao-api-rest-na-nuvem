package br.com.api_produtos.produtos.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_produtos.produtos.modelo.ProdutoModelo;
import br.com.api_produtos.produtos.modelo.RespostaModelo;
import br.com.api_produtos.produtos.servico.ProdutoServico;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "*")
public class ProdutosController {
    
    @Autowired
    private ProdutoServico ps;

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastar(@RequestBody ProdutoModelo pm){
        return ps.CadastrarComAlterar(pm, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?>alterar(@RequestBody ProdutoModelo pm) {
        return ps.CadastrarComAlterar(pm, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo>remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }
}
