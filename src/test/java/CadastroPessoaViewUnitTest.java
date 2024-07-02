import Controller.PessoaController;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import View.Pessoa.CadastroPessoaView;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author felip
 */
public class CadastroPessoaViewUnitTest {

    @Mock
    private CadastroPessoaView cadastroPessoaView = new CadastroPessoaView(new PessoaController());

    // CT01
    @Test
    public void campoNomeNaoInformado() throws Exception {

        System.out.println("Rodando Caso de Teste: CT01");
        // Informamos as variaveis para criacao da pessoa
        String nome = "";
        String cpf = "12345678910";
        String genero = "M";
        String email = "felipe@teste.com";
        String contato = "47999999999";
        String cep = "89140000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Nome” é obrigatório.\"");
        } catch (Exception e){
            Assert.assertEquals("Campo \"Nome\" é obrigatório.", e.getMessage());
        }
    }

    // CT02
    @Test
    public void campoCpfInformadoEhInvalido(){

        System.out.println("Rodando Caso de Teste: CT02");
        // Informamos as variaveis para criacao da pessoa
        String nome = "Felipe Vendrami";
        String cpf = "1234567891";
        String genero = "M";
        String email = "felipe@teste.com";
        String contato = "47999999999";
        String cep = "89140000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
            Assert.fail("Esperava-se uma Excepition: \"Campo “CPF” precisa ter no mínimo 11 caracteres\"");
        } catch (Exception e){
            Assert.assertEquals("\"Campo “CPF” precisa ter no mínimo 11 caracteres\"", e.getMessage());
        }
    }

    // CT03
    @Test
    public void campoEmailInformadoEhInvalido(){

        System.out.println("Rodando Caso de Teste: CT03");
        // Informamos as variaveis para criacao da pessoa
        String nome = "Felipe Vendrami";
        String cpf = "12345678910";
        String genero = "M";
        String email = "felipeteste";
        String contato = "47999999999";
        String cep = "89140000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
            Assert.fail("Esperava-se uma Excepition: \"Campo “E-mail” preenchido em formato inválido.\"");
        } catch (Exception e){
            Assert.assertEquals("\"Campo “E-mail” preenchido em formato inválido.\"", e.getMessage());
        }
    }

    // CT04
    @Test
    public void campoContatoInformadoEhInvalido(){

        System.out.println("Rodando Caso de Teste: CT04");
        // Informamos as variaveis para criacao da pessoa
        String nome = "Felipe Vendrami";
        String cpf = "12345678910";
        String genero = "M";
        String email = "felipe@teste.com";
        String contato = "99999999";
        String cep = "89140000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
            Assert.fail("Esperava-se uma Excepition: \"Campo “Contato” preenchido em formato inválido (verifique o DDD).\"");
        } catch (Exception e){
            Assert.assertEquals("\"Campo “Contato” preenchido em formato inválido (verifique o DDD).\"", e.getMessage());
        }
    }

    // CT05
    @Test
    public void campoCepInformadoInvalido(){

        System.out.println("Rodando Caso de Teste: CT05");
        // Informamos as variaveis para criacao da pessoa
        String nome = "Felipe Vendrami";
        String cpf = "12345678910";
        String genero = "M";
        String email = "felipe@teste.com";
        String contato = "47999999999";
        String cep = "8914000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
            Assert.fail("Esperava-se uma Excepition: \"Campo “CEP” informado é inválido.\"");
        } catch (Exception e){
            Assert.assertEquals("\"Campo “CEP” informado é inválido.\"", e.getMessage());
        }
    }

    // CT06
    @Test
    public void pessoaCadastradaComSucesso(){

        System.out.println("Rodando Caso de Teste: CT06");
        // Informamos as variaveis para criacao da pessoa
        String nome = "Felipe Vendrami";
        String cpf = "12345678910";
        String genero = "M";
        String email = "felipe@teste.com";
        String contato = "47999999999";
        String cep = "89140000";
        String logradouro = "Rua Teste";
        String bairro = "Bairro Teste";
        String cidade = "Ibirama";
        String numero = "999";
        String uf = "SC";
        String complemento = "";

        // Informamos os dados da pessoa na View
        cadastroPessoaView.setTfNome(nome);
        cadastroPessoaView.setTfCpf(cpf);
        cadastroPessoaView.setCbGenero(genero);
        cadastroPessoaView.setTfEmail(email);
        cadastroPessoaView.setTfContato(contato);
        cadastroPessoaView.setTfLogradouro(logradouro);
        cadastroPessoaView.setTfCep(cep);
        cadastroPessoaView.setTfBairro(bairro);
        cadastroPessoaView.setTfCidade(cidade);
        cadastroPessoaView.setTfNumero(numero);
        cadastroPessoaView.setTfUf(uf);
        cadastroPessoaView.setTfComplemento(complemento);

        // Validamos o metodo montaPessoa()
        try {
            cadastroPessoaView.montaPessoa();
        } catch (Exception e){
            Assert.fail("Esperava-se nenhuma Excepition. Exception: " + e.getMessage());
        }
    }
}