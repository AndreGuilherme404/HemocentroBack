package hemocentro.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_hemocentro")

public class Hemocentro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hemocentro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Coleta> coletas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hemocentro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Usuario> usuarios;

    public Hemocentro() {

    }

    public Hemocentro(Long id, String nome, String descricao, List<Coleta> coletas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.coletas = coletas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
