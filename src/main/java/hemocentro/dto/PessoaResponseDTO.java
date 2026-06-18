package hemocentro.dto;

import hemocentro.entities.Pessoa;
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
    public PessoaResponseDTO(Pessoa p){
        this.id = p.getId();
        this.nome = p.getNome();
        this.cpf = p.getCpf();
        this.email = p.getEmail();
    }
}
