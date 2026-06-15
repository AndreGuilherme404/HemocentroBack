package hemocentro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
}
