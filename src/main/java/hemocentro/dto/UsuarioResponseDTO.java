package hemocentro.dto;

import hemocentro.TipoPerfil;
import hemocentro.entities.Pessoa;
import hemocentro.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {
    Long id;
    String nome;
    TipoPerfil tipoPerfil;
    public UsuarioResponseDTO(Usuario entity){
        this.id = entity.getId();
        this.nome = entity.getLogin();
        this.tipoPerfil = entity.getTipoPerfil();
    }

}
