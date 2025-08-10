package net.codejava.rest.ecommerce.service;

import net.codejava.rest.ecommerce.model.Produto;
import net.codejava.rest.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto inserirProduto(Produto novoProduto) {
        return produtoRepository.save(novoProduto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
