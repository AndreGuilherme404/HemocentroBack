package hemocentro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class PessoaRequestDTO {
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 4, message = "O nome deve ter no mínimo 4 caracteres.")
    private String nome;
    @NotBlank(message = "O CPF é obrigatório.")
    @CPF(message = "CPF inválido.")
    private String cpf;
    @NotBlank(message = "O email é obrigatório.")
    @Email
    private String email;

    public PessoaRequestDTO() {

    }

    public PessoaRequestDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
