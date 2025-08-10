package net.codejava.rest.ecommerce.service;

import net.codejava.rest.ecommerce.model.Pagamento;
import net.codejava.rest.ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> buscarTodosPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id);
    }


}
