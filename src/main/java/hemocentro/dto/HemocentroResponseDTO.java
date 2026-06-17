package hemocentro.dto;

import hemocentro.entities.Hemocentro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HemocentroResponseDTO {
    private Long id;
    private String descricao;

    public HemocentroResponseDTO(Hemocentro entity){
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
    }
}
