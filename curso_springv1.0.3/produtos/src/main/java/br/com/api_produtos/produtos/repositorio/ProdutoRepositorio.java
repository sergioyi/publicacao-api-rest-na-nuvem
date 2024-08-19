package br.com.api_produtos.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api_produtos.produtos.modelo.ProdutoModelo;


@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {}
