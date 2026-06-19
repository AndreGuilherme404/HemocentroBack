package hemocentro.dto;

import hemocentro.TipoPerfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioRequestDTO {
    @NotBlank(message = "O login é obrigatório.")
    String login;
    @NotBlank(message = "Digite uma senha.")
    String senha;
    @NotNull(message = "O tipo de perfil é obrigatório.")
    private TipoPerfil tipoPerfil;
    @NotNull(message = "O id da pessoa é obrigatório.")
    private Long pessoaId;

}
