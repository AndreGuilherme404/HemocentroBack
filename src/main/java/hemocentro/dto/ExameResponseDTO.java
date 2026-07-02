package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.Exame;

@JsonPropertyOrder({ "id", "nome", "descricao" })
public class ExameResponseDTO {
    private Long id;
    private String nome;
    private String descricao;

    public ExameResponseDTO(Exame entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
