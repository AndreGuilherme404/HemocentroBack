package hemocentro.dto;

import hemocentro.enumerados.TipoPerfil;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import hemocentro.entities.Usuario;

@JsonPropertyOrder({ "id", "login", "tipoPerfil", "pessoaId", "hemocentroId" })
public class UsuarioResponseDTO {
    private Long id;
    private String login;
    private TipoPerfil tipoPerfil;
    private Long pessoaId;
    private Long hemocentroId;

    public UsuarioResponseDTO(Usuario entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.tipoPerfil = entity.getTipoPerfil();
        this.pessoaId = entity.getPessoa().getId();
        this.hemocentroId = entity.getHemocentro().getId();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public Long getHemocentroId() {
        return hemocentroId;
    }
}
