package hemocentro.services;



import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Pessoa;
import hemocentro.entities.Usuario;
import hemocentro.exceptions.ResourceNotFoundException;

import hemocentro.repositories.PessoaRepository;
import hemocentro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listar(){
        return usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscar(Long id){
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        return new UsuarioResponseDTO(entity);
    }
    @Transactional
    public UsuarioResponseDTO inserir(UsuarioRequestDTO dto){
        Usuario entity = new Usuario();
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        Pessoa p = pessoaRepository.findById(dto.getPessoaId()).orElseThrow(() ->
                new ResourceNotFoundException("Pessoa não encontrada. Id: " + dto.getPessoaId()));
        entity.setTipoPerfil(dto.getTipoPerfil());
        entity.setPessoa(p);
        p.addUser(entity);
        usuarioRepository.save(entity);
        return new UsuarioResponseDTO(entity);
    }
    @Transactional
    public UsuarioResponseDTO alterar(Long id, UsuarioRequestDTO dto){
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        Pessoa p = pessoaRepository.findById(dto.getPessoaId()).orElseThrow(() ->
                new ResourceNotFoundException("Pessoa não encontrada. Id: " + dto.getPessoaId()));
        entity.setTipoPerfil(dto.getTipoPerfil());
        entity.setPessoa(p);
        usuarioRepository.save(entity);
        return new UsuarioResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        usuarioRepository.deleteById(id);
    }
}
