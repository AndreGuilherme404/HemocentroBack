package hemocentro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hemocentro.dto.ExameRequestDTO;
import hemocentro.dto.ExameResponseDTO;
import hemocentro.entities.Exame;
import hemocentro.exceptions.BusinessException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.ExameRepository;

@Service
public class ExameService {
    private final ExameRepository exameRepository;

    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    @Transactional(readOnly = true)
    public List<ExameResponseDTO> listar() {
        List<Exame> lista = exameRepository.findAll();
        return lista.stream().map(ExameResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ExameResponseDTO buscar(Long id) {
        Exame entity = exameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado. Id: " + id));
        return new ExameResponseDTO(entity);
    }

    @Transactional
    public ExameResponseDTO inserir(ExameRequestDTO dto) {
        if (exameRepository.existsByNome(dto.getNome())) {
            throw new BusinessException("Já existe um exame com esse nome.");
        }

        Exame entity = new Exame();

        copiarDtoParaEntidade(dto, entity);
        entity = exameRepository.save(entity);
        return new ExameResponseDTO(entity);
    }

    @Transactional
    public ExameResponseDTO alterar(Long id, ExameRequestDTO dto) {
        Exame entity = exameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Exame não encontrado. Id: " + id));

        if (!entity.getNome().equals(dto.getNome())
                && exameRepository.existsByNome(dto.getNome())) {

            throw new BusinessException(
                    "Já existe um exame com esse nome.");
        }

        copiarDtoParaEntidade(dto, entity);
        entity = exameRepository.save(entity);

        return new ExameResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {
        Exame entity = exameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado. Id: " + id));

        exameRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(ExameRequestDTO dto, Exame entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }

}
