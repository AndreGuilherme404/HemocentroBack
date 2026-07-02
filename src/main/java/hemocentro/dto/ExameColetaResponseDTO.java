package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.ExameColeta;
import hemocentro.enumerados.Situacao;

@JsonPropertyOrder({ "id", "nome", "situacao" })
public class ExameColetaResponseDTO {
    private Long id;
    private String nome;
    private Situacao situacao;

    public ExameColetaResponseDTO(ExameColeta entity) {
        this.id = entity.getId();
        this.nome = entity.getExame().getNome();
        this.situacao = entity.getSituacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
