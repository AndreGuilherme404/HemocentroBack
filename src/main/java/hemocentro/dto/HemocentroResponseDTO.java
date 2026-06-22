package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.Hemocentro;

@JsonPropertyOrder({ "id", "nome", "descricao" })
public class HemocentroResponseDTO {
    private Long id;
    private String nome;
    private String descricao;

    public HemocentroResponseDTO(Hemocentro entity) {
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
