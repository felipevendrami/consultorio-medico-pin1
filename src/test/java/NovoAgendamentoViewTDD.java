import Controller.AgendamentoController;
import Model.Endereco;
import Model.Medico;
import Model.Pessoa;
import View.Agendamento.NovoAgendamentoView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.text.ParseException;

public class NovoAgendamentoViewTDD {

    @Mock
    NovoAgendamentoView novoAgendamentoView = new NovoAgendamentoView(new AgendamentoController());
    Pessoa pessoaMedico = new Pessoa("Felipe Vendrami", Long.parseLong("12345678910"), "M", "felipe@teste.com", Long.parseLong("47999999999"), new Endereco(89140000, "Bairro Teste", "", "Ibirama", 999, "SC", "Rua Teste"));
    Medico medico;
    Pessoa pessoaPaciente = new Pessoa("Jorge Antônio", Long.parseLong("12345678999"), "M", "jorge@teste.com", Long.parseLong("47999999999"), null);

    @Before
    public void before() throws ParseException {
        this.medico = new Medico(pessoaMedico, "123456/SC", "20/10/2020", "A", "Cardiologia");
    }

    // CT19
    @Test
    public void campoPacienteInformadoEhNulo(){

        System.out.println("Rodando Caso de Teste: CT19");

        Pessoa pessoaPaciente = null;
        Medico medico = this.medico;
        String agendarPara = "02/08/2024";
        String procedimentoARealizar = "Consulta médica para exames de rotina";

        novoAgendamentoView.setTfPaciente(pessoaPaciente);
        novoAgendamentoView.setTfMedico(medico);
        novoAgendamentoView.setTfData(agendarPara);
        novoAgendamentoView.setTaProcedimento(procedimentoARealizar);

        try{
            novoAgendamentoView.montaAgendamento();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Paciente” é de preenchimento obrigatório.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Paciente\" é de preenchimento obrigatório.", e.getMessage());
        }
    }

    // CT20
    @Test
    public void campoMedicoInformadoEhNulo(){

        System.out.println("Rodando Caso de Teste: CT20");

        Pessoa pessoaPaciente = this.pessoaPaciente;
        Medico medico = null;
        String agendarPara = "02/08/2024";
        String procedimentoARealizar = "Consulta médica para exames de rotina";

        novoAgendamentoView.setTfPaciente(pessoaPaciente);
        novoAgendamentoView.setTfMedico(medico);
        novoAgendamentoView.setTfData(agendarPara);
        novoAgendamentoView.setTaProcedimento(procedimentoARealizar);

        try{
            novoAgendamentoView.montaAgendamento();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Médico” é de preenchimento obrigatório.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Médico\" é de preenchimento obrigatório.", e.getMessage());
        }
    }

    // CT21
    @Test
    public void campoAgendarParaComDataMenorQueAtual(){

        System.out.println("Rodando Caso de Teste: CT21");

        Pessoa pessoaPaciente = this.pessoaPaciente;
        Medico medico = this.medico;
        String agendarPara = "17/03/2024";
        String procedimentoARealizar = "Consulta médica para exames de rotina";

        novoAgendamentoView.setTfPaciente(pessoaPaciente);
        novoAgendamentoView.setTfMedico(medico);
        novoAgendamentoView.setTfData(agendarPara);
        novoAgendamentoView.setTaProcedimento(procedimentoARealizar);

        try{
            novoAgendamentoView.montaAgendamento();
            Assert.fail("Esperava-se uma Excepition: \"O campo “Agendar para” está com a data de agendamento anterior que a data atual.\"");
        } catch (Exception e){
            Assert.assertEquals("O campo \"Agendar para\" está com a data de agendamento anterior que a data atual.", e.getMessage());
        }
    }

    // CT22
    @Test
    public void campoProcedimentoARealizarComMenosDe30Caracteres(){

        System.out.println("Rodando Caso de Teste: CT22");

        Pessoa pessoaPaciente = this.pessoaPaciente;
        Medico medico = this.medico;
        String agendarPara = "02/08/2024";
        String procedimentoARealizar = "Exames de rotina";

        novoAgendamentoView.setTfPaciente(pessoaPaciente);
        novoAgendamentoView.setTfMedico(medico);
        novoAgendamentoView.setTfData(agendarPara);
        novoAgendamentoView.setTaProcedimento(procedimentoARealizar);

        try{
            novoAgendamentoView.montaAgendamento();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Procedimentoa  realizar” precisa possuir no mínimo 30 caractéres. Preencha-o com mais detalhes.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Procedimentoa  realizar\" precisa possuir no mínimo 30 caractéres. Preencha-o com mais detalhes.", e.getMessage());
        }
    }

    // CT23
    @Test
    public void agendamentoCadastradoComSucesso(){

        System.out.println("Rodando Caso de Teste: CT23");

        Pessoa pessoaPaciente = this.pessoaPaciente;
        Medico medico = this.medico;
        String agendarPara = "02/08/2024";
        String procedimentoARealizar = "Exames de rotina";

        novoAgendamentoView.setTfPaciente(pessoaPaciente);
        novoAgendamentoView.setTfMedico(medico);
        novoAgendamentoView.setTfData(agendarPara);
        novoAgendamentoView.setTaProcedimento(procedimentoARealizar);

        try{
            novoAgendamentoView.montaAgendamento();
        } catch (Exception e){
            Assert.fail("Esperava-se nenhuma Excepition. Exception: " + e.getMessage());
        }
    }
}