package hemocentro.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HemocentroRequestDTO {
    @NotNull(message = "A descricao do hemocentro é obrigatória.")
    private String descricao;
}
