package hemocentro.dto;

import jakarta.validation.constraints.NotBlank;

public class ExameRequestDTO {
    @NotBlank(message = "O nome do exame é obrigatório.")
    private String nome;
    @NotBlank(message = "A descricao do exame é obrigatório.")
    private String descricao;

    public ExameRequestDTO() {
        
    }

    public ExameRequestDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
