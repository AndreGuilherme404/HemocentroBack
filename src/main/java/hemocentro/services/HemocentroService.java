package hemocentro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hemocentro.dto.HemocentroRequestDTO;
import hemocentro.dto.HemocentroResponseDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Hemocentro;
import hemocentro.entities.Usuario;
import hemocentro.exceptions.BusinessException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.HemocentroRepository;
import hemocentro.repositories.UsuarioRepository;

@Service
public class HemocentroService {

    private final HemocentroRepository hemocentroRepository;
    private final UsuarioRepository usuarioRepository;

    public HemocentroService(HemocentroRepository hemocentroRepository, UsuarioRepository usuarioRepository) {
        this.hemocentroRepository = hemocentroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<HemocentroResponseDTO> listar() {
        return hemocentroRepository.findAll()
                .stream()
                .map(HemocentroResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarPorHemocentro(Long hemocentroId) {
        if (!hemocentroRepository.existsById(hemocentroId)) {
            throw new ResourceNotFoundException("Hemocentro não encontrado. Id: " + hemocentroId);
        }

        List<Usuario> usuarios = usuarioRepository.findByHemocentroId(hemocentroId);

        return usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(usuario))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HemocentroResponseDTO buscar(Long id) {
        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hemocentro não encontrado. Id: " + id));

        return new HemocentroResponseDTO(entity);
    }

    @Transactional
    public HemocentroResponseDTO inserir(HemocentroRequestDTO dto) {

        if (hemocentroRepository.existsByNome(dto.getNome())) {
            throw new BusinessException(
                    "Já existe um hemocentro com esse nome.");
        }

        Hemocentro entity = new Hemocentro();

        copiarDtoParaEntidade(dto, entity);

        entity = hemocentroRepository.save(entity);

        return new HemocentroResponseDTO(entity);
    }

    @Transactional
    public HemocentroResponseDTO alterar(Long id, HemocentroRequestDTO dto) {

        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hemocentro não encontrado. Id: " + id));

        if (!entity.getNome().equals(dto.getNome())
                && hemocentroRepository.existsByNome(dto.getNome())) {

            throw new BusinessException(
                    "Já existe um hemocentro com esse nome.");
        }

        copiarDtoParaEntidade(dto, entity);

        entity = hemocentroRepository.save(entity);

        return new HemocentroResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {

        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hemocentro não encontrado. Id: " + id));

        hemocentroRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(
            HemocentroRequestDTO dto,
            Hemocentro entity) {

        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }
}