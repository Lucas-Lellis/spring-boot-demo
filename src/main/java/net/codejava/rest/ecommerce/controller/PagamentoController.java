package net.codejava.rest.ecommerce.controller;

import net.codejava.rest.ecommerce.model.Pagamento;
import net.codejava.rest.ecommerce.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> buscarTodosPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.buscarTodosPagamentos();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoService.buscarPagamentoPorId(id);
        return pagamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}