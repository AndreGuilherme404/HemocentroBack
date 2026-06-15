package hemocentro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExameResponseDTO {
    private Long id;
    private String descricao;
    private Long coletaId;
}
