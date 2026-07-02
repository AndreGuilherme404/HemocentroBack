package hemocentro.services;

import hemocentro.dto.PessoaRequestDTO;
import hemocentro.dto.PessoaResponseDTO;
import hemocentro.entities.Pessoa;
import hemocentro.exceptions.BusinessException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.PessoaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public List<PessoaResponseDTO> listar() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscar(Long id) {
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pessoa não encontrada. Id: " + id));

        return new PessoaResponseDTO(entity);
    }

    @Transactional
    public PessoaResponseDTO inserir(PessoaRequestDTO dto) {

        if (pessoaRepository.existsByCpf(dto.getCpf())) {
            throw new BusinessException(
                    "Já existe uma pessoa cadastrada com este CPF.");
        }

        Pessoa entity = new Pessoa();

        copiarDtoParaEntidade(dto, entity);

        entity = pessoaRepository.save(entity);

        return new PessoaResponseDTO(entity);
    }

    @Transactional
    public PessoaResponseDTO alterar(Long id, PessoaRequestDTO dto) {

        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pessoa não encontrada. Id: " + id));

        Pessoa existente = pessoaRepository.findByCpf(dto.getCpf());

        if (existente != null && !existente.getId().equals(id)) {
            throw new BusinessException(
                    "Já existe uma pessoa cadastrada com este CPF.");
        }

        copiarDtoParaEntidade(dto, entity);

        entity = pessoaRepository.save(entity);

        return new PessoaResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {

        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pessoa não encontrada. Id: " + id));

        pessoaRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(
            PessoaRequestDTO dto,
            Pessoa entity) {

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
    }
}