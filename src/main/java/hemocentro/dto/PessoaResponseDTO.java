package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.Pessoa;

@JsonPropertyOrder({ "id", "nome", "cpf", "email" })
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    public PessoaResponseDTO(Pessoa p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.cpf = p.getCpf();
        this.email = p.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
