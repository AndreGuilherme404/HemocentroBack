package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hemocentro.entities.Pessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendamentoRequestDTO {
    @NotNull(message = "O id da pessoa é obrigatório.")
    private Long pessoaId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "A data é obrigatória.")
    private LocalDate data;
    @NotBlank(message = "O horário é obrigatório.")
    private String horario;
}
