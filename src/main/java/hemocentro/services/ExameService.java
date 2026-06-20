package hemocentro.services;

import hemocentro.dto.ExameRequestDTO;
import hemocentro.dto.ExameResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExameService {
    public ExameResponseDTO buscar(Long id) {
        return null;
    }

    public ExameResponseDTO inserir(@Valid ExameRequestDTO dto) {
        return null;
    }

    public ExameResponseDTO alterar(Long id, @Valid ExameRequestDTO dto) {
        return null;
    }

    public void excluir(Long id) {
    }

    public List<ExameResponseDTO> listar() {
        return null;
    }
}
