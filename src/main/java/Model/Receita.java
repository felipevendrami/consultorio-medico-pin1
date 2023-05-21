package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita")
    private Long idReceita;

    @OneToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, precision = 11, scale = 0)
    private Long cpf;

    @Column(name = "data_receita", nullable = false)
    private Date dataReceita;

    @Column(nullable = false, length = 200)
    private String prescricao;

    public Receita() {}

    public Receita(Atendimento atendimento, String descricao, Long cpf, Date dataReceita, String prescricao) {
        this.atendimento = atendimento;
        this.descricao = descricao;
        this.cpf = cpf;
        this.dataReceita = dataReceita;
        this.prescricao = prescricao;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
}

