package hemocentro.entities;

import hemocentro.TipoPerfil;
import hemocentro.dto.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoaDoadora")
    private List<Coleta> coletas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Usuario> contas;

    public void addUser(Usuario usuario){
        contas.add(usuario);
    }
}
