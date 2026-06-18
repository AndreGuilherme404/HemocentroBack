package hemocentro.services;


import hemocentro.dto.PessoaRequestDTO;
import hemocentro.dto.PessoaResponseDTO;
import hemocentro.entities.Pessoa;
import hemocentro.exceptions.ResourceNotFoundException;

import hemocentro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaResponseDTO> listar(){
        return pessoaRepository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public PessoaResponseDTO buscar(Long id){
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        return new PessoaResponseDTO(entity);
    }
    @Transactional
    public PessoaResponseDTO inserir(PessoaRequestDTO dto){
        Pessoa entity = new Pessoa();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        return new PessoaResponseDTO(entity);
    }
    @Transactional
    public PessoaResponseDTO alterar(Long id, PessoaRequestDTO dto){
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        return new PessoaResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));


        pessoaRepository.deleteById(id);
    }
}
