package net.codejava.rest.ecommerce.service;

import net.codejava.rest.ecommerce.model.ItemPedido;
import net.codejava.rest.ecommerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> buscarTodosItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> buscarItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id);
    }
    
    
}
