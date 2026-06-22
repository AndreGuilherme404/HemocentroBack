package hemocentro.dto;

import hemocentro.enumerados.TipoPerfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDTO {
    @NotBlank(message = "O login é obrigatório.")
    private String login;

    @NotBlank(message = "Digite uma senha.")
    private String senha;

    @NotNull(message = "O tipo de perfil é obrigatório.")
    private TipoPerfil tipoPerfil;

    @NotNull(message = "O id da pessoa é obrigatório.")
    private Long pessoaId;

    @NotNull(message = "O id do hemocentro é obrigatório.")
    private Long hemocentroId;

    public UsuarioRequestDTO() {

    }

    public UsuarioRequestDTO(String login, String senha, TipoPerfil tipoPerfil, Long pessoaId, Long hemocentroId) {
        this.login = login;
        this.senha = senha;
        this.tipoPerfil = tipoPerfil;
        this.pessoaId = pessoaId;
        this.hemocentroId = hemocentroId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getHemocentroId() {
        return hemocentroId;
    }

    public void setHemocentroId(Long hemocentroId) {
        this.hemocentroId = hemocentroId;
    }

}
