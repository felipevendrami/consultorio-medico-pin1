package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa paciente;

    @Column(nullable = false, length = 128)
    private String procedimento;

    @Column(nullable = false)
    private Date data;

    public Agendamento() {}

    public Agendamento(Medico medico, String procedimento, String data, Pessoa paciente) throws ParseException {
        this.medico = medico;
        this.procedimento = procedimento;
        this.data = formatStringtoDate(data);
        this.paciente = paciente;
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

    public Pessoa getPaciente() {
        return paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    private Date formatStringtoDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(data);
    }
    
    public String formatDatetoString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.data);
    }
}

