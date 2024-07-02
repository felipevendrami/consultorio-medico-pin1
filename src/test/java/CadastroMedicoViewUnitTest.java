
import Controller.MedicoController;
import Model.Pessoa;
import View.Medico.CadastroMedicoView;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import Model.Endereco;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author felip
 */
public class CadastroMedicoViewUnitTest {
    @Mock
    CadastroMedicoView cadastroMedicoView = new CadastroMedicoView(new MedicoController());
    Pessoa pessoa = new Pessoa("Felipe Vendrami", Long.parseLong("12345678910"), "M", "felipe@teste.com", Long.parseLong("47999999999"), new Endereco(89140000, "Bairro Teste", "", "Ibirama", 999, "SC", "Rua Teste"));


    // CT07
    @Test
    public void pessoaNaoSelecionada(){

        System.out.println("Rodando Caso de Teste: CT07");
        // Informamos as variaveis
        Pessoa pessoa = null;
        String especialidade = "Cardiologia";
        String crm = "123456/SC";
        String dataInscricao = "20/10/2020";
        String situacao = "A";
        String senha = "testesenha";

        // Informamos os dados do medico na View
        cadastroMedicoView.setTfPessoa(pessoa);
        cadastroMedicoView.setTfEspecialidade(especialidade);
        cadastroMedicoView.setTfCrm(crm);
        cadastroMedicoView.setTfDataInscricao(dataInscricao);
        cadastroMedicoView.setTfSituacao(situacao);
        cadastroMedicoView.setTfSenhaAcesso(senha);

        // Valida o metodo montaMedico()
        try {
            cadastroMedicoView.montaMedico();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Pessoa” é obrigatório.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Pessoa\" é obrigatório.", e.getMessage());
        }
    }

    // CT08
    @Test
    public void campoEspecialidadeNaoPreenchido(){

        System.out.println("Rodando Caso de Teste: CT08");
        // Informamos as variaveis
        Pessoa pessoa = this.pessoa;
        String especialidade = "";
        String crm = "123456/SC";
        String dataInscricao = "20/10/2020";
        String situacao = "A";
        String senha = "testesenha";

        // Informamos os dados do medico na View
        cadastroMedicoView.setTfPessoa(pessoa);
        cadastroMedicoView.setTfEspecialidade(especialidade);
        cadastroMedicoView.setTfCrm(crm);
        cadastroMedicoView.setTfDataInscricao(dataInscricao);
        cadastroMedicoView.setTfSituacao(situacao);
        cadastroMedicoView.setTfSenhaAcesso(senha);

        // Valida o metodo montaMedico()
        try {
            cadastroMedicoView.montaMedico();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Especialidade” é obrigatório.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Especialidade\" é obrigatório.", e.getMessage());
        }
    }

    // CT09
    @Test
    public void campoCrmInformadoEhInvalido(){

        System.out.println("Rodando Caso de Teste: CT09");
        // Informamos as variaveis
        Pessoa pessoa = this.pessoa;
        String especialidade = "Cardiologia";
        String crm = "123456C";
        String dataInscricao = "20/10/2020";
        String situacao = "A";
        String senha = "testesenha";

        // Informamos os dados do medico na View
        cadastroMedicoView.setTfPessoa(pessoa);
        cadastroMedicoView.setTfEspecialidade(especialidade);
        cadastroMedicoView.setTfCrm(crm);
        cadastroMedicoView.setTfDataInscricao(dataInscricao);
        cadastroMedicoView.setTfSituacao(situacao);
        cadastroMedicoView.setTfSenhaAcesso(senha);

        // Valida o metodo montaMedico()
        try {
            cadastroMedicoView.montaMedico();
            Assert.fail("Esperava-se uma Excepition: \"Campo “CRM” preenchido em formato inválido.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"CRM\" preenchido em formato inválido.", e.getMessage());
        }
    }


    // CT10
    @Test
    public void medicoCadastradoComSucesso(){

        System.out.println("Rodando Caso de Teste: CT10");
        // Informamos as variaveis
        Pessoa pessoa = this.pessoa;
        String especialidade = "Cardiologia";
        String crm = "123456/SC";
        String dataInscricao = "20/10/2020";
        String situacao = "A";
        String senha = "testesenha";

        // Informamos os dados do medico na View
        cadastroMedicoView.setTfPessoa(pessoa);
        cadastroMedicoView.setTfEspecialidade(especialidade);
        cadastroMedicoView.setTfCrm(crm);
        cadastroMedicoView.setTfDataInscricao(dataInscricao);
        cadastroMedicoView.setTfSituacao(situacao);
        cadastroMedicoView.setTfSenhaAcesso(senha);

        // Valida o metodo montaMedico()
        try {
            cadastroMedicoView.montaMedico();
        } catch (Exception e){
            Assert.fail("Esperava-se nenhuma Excepition. Exception: " + e.getMessage());
        }
    }
}