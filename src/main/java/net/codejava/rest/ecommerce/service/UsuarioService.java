package net.codejava.rest.ecommerce.service;

import jakarta.transaction.Transactional;
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

    @Transactional
    public Usuario atualizarPerfilUsuario(Long id, Usuario dadosNovos) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            if (dadosNovos.getNome() != null) {
                usuario.setNome(dadosNovos.getNome());
            }
            if (dadosNovos.getEmail() != null) {
                usuario.setEmail(dadosNovos.getEmail());
            }
            if (dadosNovos.getSenha() != null) {
                usuario.setSenha(dadosNovos.getSenha());
            }

            return usuarioRepository.save(usuario);
        }
        else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }
}
