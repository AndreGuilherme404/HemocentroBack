package hemocentro.dto;

import hemocentro.TipoPerfil;
import hemocentro.entities.Pessoa;
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
    public UsuarioResponseDTO(Pessoa entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.tipoPerfil = entity.getTipoPerfil();
    }

}
