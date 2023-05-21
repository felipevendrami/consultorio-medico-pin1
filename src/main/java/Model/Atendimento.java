package Model;

import javax.persistence.*;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long idAtendimento;

    @OneToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    @Column(nullable = false, length = 200)
    private String sintoma;

    @Column(length = 200)
    private String alergia;

    @Column(nullable = false, length = 200)
    private String diagnostico;

    public Atendimento() {}

    public Atendimento(Agendamento agendamento, String sintoma, String alergia, String diagnostico) {
        this.agendamento = agendamento;
        this.sintoma = sintoma;
        this.alergia = alergia;
        this.diagnostico = diagnostico;
    }

    public Long getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Long idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}

