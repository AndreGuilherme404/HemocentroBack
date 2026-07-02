package hemocentro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ColetaRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "A data da coleta é obrigatória.")
    private LocalDate dataColeta;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "A data de validade é obrigatória.")
    private LocalDate dataValidade;
    @NotNull(message = "O id do hemocentro é obrigatório.")
    private Long hemocentroId;
    @NotNull(message = "O id da pessoa é obrigatório.")
    private Long pessoaId;
    @NotBlank(message = "O tipo sanguíneo é obrigatório.")
    private String tipoSanguineo;

    public ColetaRequestDTO() {

    }

    public ColetaRequestDTO(LocalDate dataColeta, LocalDate dataValidade, Long hemocentroId, Long pessoaId,
            String tipoSanguineo) {
        this.dataColeta = dataColeta;
        this.dataValidade = dataValidade;
        this.hemocentroId = hemocentroId;
        this.pessoaId = pessoaId;
        this.tipoSanguineo = tipoSanguineo;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getHemocentroId() {
        return hemocentroId;
    }

    public void setHemocentroId(Long hemocentroId) {
        this.hemocentroId = hemocentroId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

}
