package hemocentro.services;

import hemocentro.dto.ColetaRequestDTO;
import hemocentro.dto.ColetaResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColetaService {
    public List<ColetaResponseDTO> listar() {
        return null;
    }

    public ColetaResponseDTO buscar(Long id) {
        return null;
    }

    public ColetaResponseDTO inserir(@Valid ColetaRequestDTO dto) {
        return null;
    }

    public ColetaResponseDTO alterar(Long id, @Valid ColetaRequestDTO dto) {
        return null;
    }

    public void excluir(Long id) {

    }
}
