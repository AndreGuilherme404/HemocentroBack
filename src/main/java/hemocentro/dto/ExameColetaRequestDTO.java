package hemocentro.dto;

import hemocentro.enumerados.Situacao;
import jakarta.validation.constraints.NotNull;

public class ExameColetaRequestDTO {
    @NotNull(message = "O id do exame é obrigatório.")
    private Long exameId;

    @NotNull(message = "A situação da coleta é obrigatória.")
    private Situacao situacao;

    @NotNull(message = "O id da coleta é obrigatório")
    private Long coletaId;

    public ExameColetaRequestDTO(Long exameId, Situacao situacao, Long coletaId) {
        this.exameId = exameId;
        this.situacao = situacao;
        this.coletaId = coletaId;
    }

    public Long getExameId() {
        return exameId;
    }

    public void setExameId(Long exameId) {
        this.exameId = exameId;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Long getColetaId() {
        return coletaId;
    }

    public void setColetaId(Long coletaId) {
        this.coletaId = coletaId;
    }

}
