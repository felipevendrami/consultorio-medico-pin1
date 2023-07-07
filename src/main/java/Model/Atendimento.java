package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long idAtendimento;

    @JoinColumn(name = "id_agendamento")
    private Long agendamento;

    @Column(nullable = false, length = 200)
    private String sintoma;

    @Column(length = 200)
    private String alergia;

    @Column(nullable = false, length = 200)
    private String diagnostico;

    @Column(nullable = false, length = 200)
    private String procedimento;

    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    
    @Column(nullable = false)
    private java.util.Date data;
    
    public Atendimento() {}

    public Atendimento(Long agendamento, Medico medico, String sintoma, String alergia, String diagnostico, String data, String procedimento) throws ParseException {
        this.agendamento = agendamento;
        this.sintoma = sintoma;
        this.alergia = alergia;
        this.diagnostico = diagnostico;
        this.medico = medico;
        this.data = formatStringtoDate(data);
        this.procedimento = procedimento;
    }

    public Long getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Long idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public Long getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Long agendamento) {
        this.agendamento = agendamento;
    }
    
    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
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
    
     private java.util.Date formatStringtoDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(data);
    }
    
    public String formatDatetoString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.data);
    }

}

