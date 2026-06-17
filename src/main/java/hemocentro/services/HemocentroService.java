package hemocentro.services;

import hemocentro.dto.HemocentroRequestDTO;
import hemocentro.dto.HemocentroResponseDTO;
import hemocentro.entities.Hemocentro;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.repositories.HemocentroRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HemocentroService {
    @Autowired
    private HemocentroRepository hemocentroRepository;

    @Transactional(readOnly = true)
    public List<HemocentroResponseDTO> listar(){
        return hemocentroRepository.findAll().stream().map(HemocentroResponseDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public HemocentroResponseDTO buscar(Long id){
        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        return new HemocentroResponseDTO(entity);
    }
    @Transactional
    public HemocentroResponseDTO inserir(HemocentroRequestDTO dto){
        Hemocentro entity = new Hemocentro();
        entity.setDescricao(dto.getDescricao());
        entity = hemocentroRepository.save(entity);
        return new HemocentroResponseDTO(entity);
    }
    @Transactional
    public HemocentroResponseDTO alterar(Long id, HemocentroRequestDTO dto){
        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));
        entity.setDescricao(dto.getDescricao());
        hemocentroRepository.save(entity);
        return new HemocentroResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        Hemocentro entity = hemocentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O id " + id + " não foi encontrado"));


        hemocentroRepository.deleteById(id);
    }
}
