import Controller.AtendimentoController;
import Model.Agendamento;
import Model.Endereco;
import Model.Medico;
import Model.Pessoa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.text.ParseException;

public class ConsultaAgendamentoViewTDD {

    @Mock
    AtendimentoController atendimentoController = new AtendimentoController();
    Pessoa pessoaMedico = new Pessoa("Felipe Vendrami", Long.parseLong("12345678910"), "M", "felipe@teste.com", Long.parseLong("47999999999"), new Endereco(89140000, "Bairro Teste", "", "Ibirama", 999, "SC", "Rua Teste"));
    Medico medico;
    Pessoa pessoaPaciente = new Pessoa("Jorge Antônio", Long.parseLong("12345678999"), "M", "jorge@teste.com", Long.parseLong("47999999999"), null);
    Agendamento agendamento;

    @Before
    public void before() throws ParseException {
        this.agendamento = new Agendamento(medico, "Consulta médica para exames de rotina", "02/08/2024", pessoaPaciente);
    }

    // CT24
    @Test
    public void excluirUmAgendamentoExistente(){

        System.out.println("Rodando Caso de Teste: CT24");

        try {
            atendimentoController.excluirAtendimento(Long.parseLong("1"));
        } catch (Exception e){
            Assert.fail("Esperava-se nenhuma Excepition. Exception: " + e.getMessage());
        }
    }
}
