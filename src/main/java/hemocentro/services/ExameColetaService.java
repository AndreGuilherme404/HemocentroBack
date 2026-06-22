package hemocentro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hemocentro.dto.ExameColetaRequestDTO;
import hemocentro.dto.ExameColetaResponseDTO;
import hemocentro.entities.Coleta;
import hemocentro.entities.Exame;
import hemocentro.entities.ExameColeta;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.ColetaRepository;
import hemocentro.repositories.ExameColetaRepository;
import hemocentro.repositories.ExameRepository;

@Service
public class ExameColetaService {
    private final ExameColetaRepository exameColetaRepository;
    private final ColetaRepository coletaRepository;
    private final ExameRepository exameRepository;

    public ExameColetaService(ExameColetaRepository exameColetaRepository, ColetaRepository coletaRepository,
            ExameRepository exameRepository) {
        this.exameColetaRepository = exameColetaRepository;
        this.coletaRepository = coletaRepository;
        this.exameRepository = exameRepository;
    }

    // Lista os exames de uma coleta
    @Transactional(readOnly = true)
    public List<ExameColetaResponseDTO> listar(Long coletaId) {
        if (!coletaRepository.existsById(coletaId)) {
            throw new ResourceNotFoundException("Coleta não encontrada. Id: " + coletaId);
        }

        List<ExameColeta> listaExames = exameColetaRepository.findAllByColetaId(coletaId);
        return listaExames.stream().map(ExameColetaResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ExameColetaResponseDTO buscar(Long id) {

        ExameColeta entity = exameColetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Exame da coleta não encontrado. Id: " + id));

        return new ExameColetaResponseDTO(entity);
    }

    @Transactional
    public ExameColetaResponseDTO inserir(ExameColetaRequestDTO dto) {
        ExameColeta entity = new ExameColeta();
        copiarDtoParaEntidade(dto, entity);
        entity = exameColetaRepository.save(entity);
        return new ExameColetaResponseDTO(entity);
    }

    @Transactional
    public ExameColetaResponseDTO alterar(Long coletaId, ExameColetaRequestDTO dto) {
        ExameColeta entity = exameColetaRepository.findById(coletaId)
                .orElseThrow(() -> new ResourceNotFoundException("Exame da Coleta não encontrada. Id: " + coletaId));
        copiarDtoParaEntidade(dto, entity);
        entity = exameColetaRepository.save(entity);
        return new ExameColetaResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id) {
        ExameColeta entity = exameColetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exame da Coleta não encontrada. Id: " + id));

        exameColetaRepository.delete(entity);
    }

    private void copiarDtoParaEntidade(ExameColetaRequestDTO dto,
            ExameColeta entity) {

        Exame exame = exameRepository.findById(dto.getExameId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Exame não encontrado. Id: " + dto.getExameId()));

        Coleta coleta = coletaRepository.findById(dto.getColetaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Coleta não encontrada. Id: " + dto.getColetaId()));

        entity.setExame(exame);
        entity.setColeta(coleta);
        entity.setSituacao(dto.getSituacao());
    }

}
