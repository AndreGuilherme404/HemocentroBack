package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hemocentro.entities.Hemocentro;
import hemocentro.entities.Pessoa;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColetaRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "A data da coleta é obrigatória.")
    private LocalDate dataColeta;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "A data de validade é obrigatória.")
    private LocalDate dataValidade;
    @NotNull(message = "O id do hemocentro é obrigatório.")
    private Long hemocentroId;
    @NotNull(message = "O id da pessoa é obrigatório.")
    private Long pessoaId;
    //sem a lista de exames porque os exames sao feitos após a coleta então nao faz sentido pedir eles aqui


}
