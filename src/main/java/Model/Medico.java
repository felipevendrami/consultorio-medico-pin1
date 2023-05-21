package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author renan
 */
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

    @Column(nullable = false, length = 12)
    private String crm;

    @Column(name = "data_inscricao", nullable = false)
    private Date dataInscricao;

    @Column(nullable = false, length = 1)
    private String situacao;

    public Medico() {}

    public Medico(Pessoa pessoa, Especialidade especialidade, String crm, Date dataInscricao, String situacao) {
        this.pessoa = pessoa;
        this.especialidade = especialidade;
        this.crm = crm;
        this.dataInscricao = dataInscricao;
        this.situacao = situacao;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

