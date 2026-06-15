package hemocentro.dto;

import hemocentro.entities.Hemocentro;
import hemocentro.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColetaResponseDTO {
    private Long id;
    private LocalDate dataColeta;
    private LocalDate dataValidade;
    private Long hemocentroId;
    private Long pessoaDoadora;
    private List<ExameResponseDTO> exames;
    //pensando no front-end, quando for pedir pra ver uma coleta eu tambem mostro os dados
    //dos exames feitos e os dados sobre eles
}
