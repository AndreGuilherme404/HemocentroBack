package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hemocentro.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendamentoResponseDTO {
    private Long id;
    private Long pessoaId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;
    private String horario;
}
