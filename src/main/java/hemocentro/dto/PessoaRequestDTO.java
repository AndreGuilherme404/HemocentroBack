package hemocentro.dto;

import jakarta.validation.constraints.Email;
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
public class PessoaRequestDTO {
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 4, message = "O nome deve ter no mínimo 4 caracteres.")
    private String nome;
    @NotBlank(message = "O cpf é obrigatório.")
    @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 caracteres.")
    private String cpf;
    @NotBlank(message = "O email é obrigatório.")
    @Email
    private String email;
}
