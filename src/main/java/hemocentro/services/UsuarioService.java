package hemocentro.services;

import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Hemocentro;
import hemocentro.entities.Pessoa;
import hemocentro.entities.Usuario;
import hemocentro.exceptions.BusinessException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.HemocentroRepository;
import hemocentro.repositories.PessoaRepository;
import hemocentro.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PessoaRepository pessoaRepository;
    private final HemocentroRepository hemocentroRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PessoaRepository pessoaRepository,
            HemocentroRepository hemocentroRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pessoaRepository = pessoaRepository;
        this.hemocentroRepository = hemocentroRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscar(Long id) {
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        return new UsuarioResponseDTO(entity);
    }

    public List<UsuarioResponseDTO> listarPorPessoa(Long pessoaId) {
        List<Usuario> usuarios = usuarioRepository.findAllByPessoaId(pessoaId);

        return usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public UsuarioResponseDTO inserir(UsuarioRequestDTO dto) {

        if (usuarioRepository.existsByLogin(dto.getLogin())) {
            throw new BusinessException(
                    "Já existe um usuário com esse login.");
        }

        Usuario entity = new Usuario();

        copiarDtoParaEntidade(dto, entity);

        entity = usuarioRepository.save(entity);

        return new UsuarioResponseDTO(entity);
    }

    @Transactional
    public UsuarioResponseDTO alterar(Long id, UsuarioRequestDTO dto) {

        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado. Id: " + id));

        Usuario existente = usuarioRepository.findByLogin(dto.getLogin());

        if (existente != null && !existente.getId().equals(id)) {
            throw new BusinessException(
                    "Já existe um usuário com esse login.");
        }

        copiarDtoParaEntidade(dto, entity);

        entity = usuarioRepository.save(entity);

        return new UsuarioResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        usuarioRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(UsuarioRequestDTO dto, Usuario entity) {
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pessoa não encontrada. Id: " + dto.getPessoaId()));

        Hemocentro hemocentro = hemocentroRepository.findById(dto.getHemocentroId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hemocentro não encontrado. Id: " + dto.getHemocentroId()));

        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity.setTipoPerfil(dto.getTipoPerfil());

        entity.setPessoa(pessoa);
        entity.setHemocentro(hemocentro);
    }
}
