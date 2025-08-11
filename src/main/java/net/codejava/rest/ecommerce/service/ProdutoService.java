package net.codejava.rest.ecommerce.service;

import jakarta.transaction.Transactional;
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

    @Transactional
    public Produto atualizarProduto(Long id, Produto dadosNovos) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();

            if (dadosNovos.getNome() != null) {
                produto.setNome(dadosNovos.getNome());
            }
            if (dadosNovos.getPreco() != null) {
                produto.setPreco(dadosNovos.getPreco());
            }
            if (dadosNovos.getEstoque() != null) {
                produto.setEstoque(dadosNovos.getEstoque());
            }
            if (dadosNovos.getImageUrl() != null) {
                produto.setImageUrl(dadosNovos.getImageUrl());
            }

            return produtoRepository.save(produto);
        }
        else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }
}
