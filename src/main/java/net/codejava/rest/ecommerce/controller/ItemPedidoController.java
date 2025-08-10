package net.codejava.rest.ecommerce.controller;

import net.codejava.rest.ecommerce.model.ItemPedido;
import net.codejava.rest.ecommerce.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itemPedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> buscarTodosItemPedidos() {
        List<ItemPedido> itemPedidos = itemPedidoService.buscarTodosItemPedidos();
        return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarItemPedidoPorId(@PathVariable Long id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.buscarItemPedidoPorId(id);
        return itemPedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}