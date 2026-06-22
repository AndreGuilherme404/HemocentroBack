package hemocentro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_coleta")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataColeta;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hemocentro_id")
    private Hemocentro hemocentro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaDoadora;

    public Coleta() {
    }

    public Coleta(Long id, LocalDate dataColeta, LocalDate dataValidade, Hemocentro hemocentro, Pessoa pessoaDoadora) {
        this.id = id;
        this.dataColeta = dataColeta;
        this.dataValidade = dataValidade;
        this.hemocentro = hemocentro;
        this.pessoaDoadora = pessoaDoadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Hemocentro getHemocentro() {
        return hemocentro;
    }

    public void setHemocentro(Hemocentro hemocentro) {
        this.hemocentro = hemocentro;
    }

    public Pessoa getPessoaDoadora() {
        return pessoaDoadora;
    }

    public void setPessoaDoadora(Pessoa pessoaDoadora) {
        this.pessoaDoadora = pessoaDoadora;
    }
}
