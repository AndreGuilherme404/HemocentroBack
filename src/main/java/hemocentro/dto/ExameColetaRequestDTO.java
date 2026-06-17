package hemocentro.dto;

import hemocentro.Situacao;
import hemocentro.entities.Exame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExameColetaRequestDTO {
    @NotNull(message = "O id do exame é obrigatório.")
    private Long exameId;

    @NotBlank(message = "A situação da coleta é obrigatório.")
    private Situacao situacao;

    @NotNull(message = "O id da coleta é obrigatório")
    private Long coletaId;
}
