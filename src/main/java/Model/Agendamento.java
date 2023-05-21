package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Long idAgendamento;

    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @Column(nullable = false, length = 128)
    private String procedimento;

    @Column(nullable = false)
    private Date data;

    public Agendamento() {}

    public Agendamento(Medico medico, String procedimento, Date data) {
        this.medico = medico;
        this.procedimento = procedimento;
        this.data = data;
    }

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

