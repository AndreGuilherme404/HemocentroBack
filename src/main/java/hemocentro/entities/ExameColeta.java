package hemocentro.entities;

import hemocentro.enumerados.Situacao;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_exame_coleta")
public class ExameColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Situacao situacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coleta_id", nullable = false)
    private Coleta coleta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exame_id", nullable = false)
    private Exame exame;

    public ExameColeta() {

    }

    public ExameColeta(Long id, Exame exame, Situacao resultado) {
        this.id = id;
        this.exame = exame;
        this.situacao = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao resultado) {
        this.situacao = resultado;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }
}
