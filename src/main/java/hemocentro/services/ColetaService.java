package hemocentro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hemocentro.dto.ColetaRequestDTO;
import hemocentro.dto.ColetaResponseDTO;
import hemocentro.entities.Coleta;
import hemocentro.entities.Hemocentro;
import hemocentro.entities.Pessoa;
import hemocentro.enumerados.TipoSanguineo;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.ColetaRepository;
import hemocentro.repositories.HemocentroRepository;
import hemocentro.repositories.PessoaRepository;

@Service
public class ColetaService {
    private final ColetaRepository coletaRepository;
    private final HemocentroRepository hemocentroRepository;
    private final PessoaRepository pessoaRepository;

    public ColetaService(ColetaRepository coletaRepository, HemocentroRepository hemocentroRepository,
            PessoaRepository pessoaRepository) {
        this.coletaRepository = coletaRepository;
        this.hemocentroRepository = hemocentroRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public List<ColetaResponseDTO> listar() {
        return coletaRepository.findAll().stream().map(ColetaResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ColetaResponseDTO buscar(Long id) {
        Coleta entity = coletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        return new ColetaResponseDTO(entity);
    }

    @Transactional
    public ColetaResponseDTO inserir(ColetaRequestDTO dto) {
        Coleta entity = new Coleta();
        copiarDtoParaEntidade(dto, entity);
        entity = coletaRepository.save(entity);
        return new ColetaResponseDTO(entity);
    }

    @Transactional
    public ColetaResponseDTO alterar(Long id, ColetaRequestDTO dto) {
        Coleta entity = coletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        copiarDtoParaEntidade(dto, entity);
        entity = coletaRepository.save(entity);
        return new ColetaResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {
        Coleta entity = coletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));

        coletaRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(ColetaRequestDTO dto, Coleta entity) {
        Hemocentro hemocentro = hemocentroRepository.findById(dto.getHemocentroId()).orElseThrow(
                () -> new ResourceNotFoundException("Hemocentro não encontrado. Id: " + dto.getHemocentroId()));

        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada. Id: " + dto.getPessoaId()));
            
        entity.setDataColeta(dto.getDataColeta());
        entity.setDataValidade(dto.getDataValidade());
        entity.setHemocentro(hemocentro);
        entity.setPessoaDoadora(pessoa);
        entity.setTipoSanguineo(TipoSanguineo.fromString(dto.getTipoSanguineo()));
    }
}
