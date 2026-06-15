package hemocentro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExameRequestDTO {
    @NotBlank(message = "A descricao do exame é obrigatório.")
    private String descricao;
    @NotNull(message = "O id da coleta é obrigatório.")
    private Long coletaId;
}
