package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author renan
 */
@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade")
    private Long idEspecialidade;

    @Column(nullable = false, length = 60)
    private String descricao;

    @Column(nullable = false, length = 200)
    private String procedimentos;

    @Column(name = "valor_consulta", nullable = false)
    private double valorConsulta;

    public Especialidade() {}

    public Especialidade(String descricao, String procedimentos, double valorConsulta) {
        this.descricao = descricao;
        this.procedimentos = procedimentos;
        this.valorConsulta = valorConsulta;
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(String procedimentos) {
        this.procedimentos = procedimentos;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
