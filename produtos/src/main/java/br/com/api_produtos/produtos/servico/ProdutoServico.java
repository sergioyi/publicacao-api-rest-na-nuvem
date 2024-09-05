package br.com.api_produtos.produtos.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api_produtos.produtos.modelo.ProdutoModelo;
import br.com.api_produtos.produtos.modelo.RespostaModelo;
import br.com.api_produtos.produtos.repositorio.ProdutoRepositorio;



@Service
public class ProdutoServico {
    @Autowired
    private  ProdutoRepositorio pr;
    @Autowired
    private  RespostaModelo rm;

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }
    public ResponseEntity<?>CadastrarComAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMessage("o nome do produto é obrigatósria"); 
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(acao.equals("cadastrar")){
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
        }
    }
    public ResponseEntity<RespostaModelo>remover(long codigo){
        pr.deleteById(codigo);
        rm.setMessage("o produto foi removido com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
