package hemocentro.dto;

import jakarta.validation.constraints.NotBlank;

public class HemocentroRequestDTO {
    @NotBlank(message = "O nome do hemocentro é obrigatório.")
    private String nome;

    @NotBlank(message = "A descricao do hemocentro é obrigatória.")
    private String descricao;

    public HemocentroRequestDTO() {
        
    }

    public HemocentroRequestDTO(String nome, String descricao) {
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
