package net.codejava.rest.ecommerce.controller;

import net.codejava.rest.ecommerce.model.Endereco;
import net.codejava.rest.ecommerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos() {
        List<Endereco> enderecos = enderecoService.buscarTodosEnderecos();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.buscarEnderecoPorId(id);
        return endereco.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Endereco> inserirEndereco(@RequestBody Endereco novoEndereco) {
        Endereco enderecoInserido = enderecoService.inserirEndereco(novoEndereco);
        return new ResponseEntity<>(enderecoInserido, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}