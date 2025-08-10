package net.codejava.rest.ecommerce.service;

import net.codejava.rest.ecommerce.model.Pedido;
import net.codejava.rest.ecommerce.model.Usuario;
import net.codejava.rest.ecommerce.repository.PedidoRepository;
import net.codejava.rest.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Pedido> buscarHistoricoPedidosPorUsuario(Long id) {
        return pedidoRepository.buscarPorUsarioId(id);
    }
}
