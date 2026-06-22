package hemocentro.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoaDoadora")
    private List<Coleta> coletas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Usuario> contas = new ArrayList<>();

    public void addUser(Usuario usuario) {
        contas.add(usuario);
        usuario.setPessoa(this);
    }

    public Pessoa() {

    }

    public Pessoa(Long id, String nome, String cpf, String email, List<Coleta> coletas, List<Usuario> contas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.coletas = coletas;
        this.contas = contas;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }

    public List<Usuario> getContas() {
        return contas;
    }

    public void setContas(List<Usuario> contas) {
        this.contas = contas;
    }

}
