package hemocentro.services;

import hemocentro.dto.ExameColetaRequestDTO;
import hemocentro.dto.ExameColetaResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExameColetaService {
    public List<ExameColetaResponseDTO> listar() {
        return null;
    }

    public ExameColetaResponseDTO buscar(Long id) {
        return null;
    }

    public ExameColetaResponseDTO inserir(@Valid ExameColetaRequestDTO dto) {
        return null;
    }

    public ExameColetaResponseDTO alterar(Long id, @Valid ExameColetaRequestDTO dto) {
        return null;
    }

    public void excluir(Long id) {

    }
}
