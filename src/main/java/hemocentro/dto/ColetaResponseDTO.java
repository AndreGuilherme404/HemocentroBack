package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.Coleta;

import java.time.LocalDate;

@JsonPropertyOrder({ "id", "dataColeta", "dataValidade", "hemocentroId", "pessoaId", "exames" })
public class ColetaResponseDTO {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataColeta;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataValidade;
    private Long hemocentroId;
    private Long pessoaId;
    // pensando no front-end, quando for pedir pra ver uma coleta eu tambem mostro
    // os dados
    // dos exames feitos e os dados sobre eles

    public ColetaResponseDTO(Coleta entity) {
        this.id = entity.getId();
        this.dataColeta = entity.getDataColeta();
        this.dataValidade = entity.getDataValidade();
        this.hemocentroId = entity.getHemocentro().getId();
        this.pessoaId = entity.getPessoaDoadora().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public Long getHemocentroId() {
        return hemocentroId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

}
