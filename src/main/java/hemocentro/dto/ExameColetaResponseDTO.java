package hemocentro.dto;

import hemocentro.Situacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExameColetaResponseDTO {
    private Long id;
    private String nome;
    private Situacao situacao;
}
