import DAO.AcessoBD;
import DAO.PessoaDao;
import DAO.UsuarioDao;
import Model.Endereco;
import Model.Pessoa;
import Model.Usuario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author felip
 */
public class UsuarioDaoIntegrationTest {

    @Before
    public void before() throws Exception {
        // Instanciamos o banco H2 para o escopo de testes
        AcessoBD.setPersistenseUnitTest();

        // Persistimos as pessoas de teste
        Pessoa pessoa1 = new Pessoa("Valdemar da Costa", Long.parseLong("98765432100"), "M", "valdemar@teste.com", Long.parseLong("11777777777"), new Endereco(0125000, "Bairro Pacaembu", "Rua de asfalto", "São Paulo", 1122, "SP", "Alm Major Vieira"));
        Pessoa pessoa2 = new Pessoa("Jorge Antônio", Long.parseLong("12345678999"), "M", "jorge@teste.com", Long.parseLong("47999999999"), new Endereco(89140000, "Bairro Teste", "", "Ibirama", 999, "SC", "Rua Teste"));
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.addPessoa(pessoa1);
        pessoaDao.addPessoa(pessoa2);

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario(pessoa2, "senhaacesso", "A");
        usuarioDao.addUsuario(usuario);
    }

    // CT11
    @Test
    public void validaSeUsuarioSalvoEstaRelacionadoAPessoaCorreta() throws Exception{

        System.out.println("Rodando Caso de Teste: CT11");
        // Criamos e persistimos o usuario de teste
        UsuarioDao usuarioDao = new UsuarioDao();

        // Carregamos as informacoes do usuario para validacao
        Usuario usuarioPersistido = usuarioDao.getUsuario(Long.parseLong("1"));
        String nomeUsuarioEsperado = "Jorge Antônio";
        Long cpfUsuarioEsperado = Long.parseLong("12345678999");
        String generoUsuarioEsperado = "M";
        String emailUsuarioEsperado = "jorge@teste.com";
        Long contatoUsuarioEsperado = Long.parseLong("47999999999");

        // Aplicamos as validacoes
        Assert.assertNotNull(usuarioPersistido.getPessoa());
        Assert.assertEquals(nomeUsuarioEsperado, usuarioPersistido.getPessoa().getNome());
        Assert.assertEquals(cpfUsuarioEsperado, usuarioPersistido.getPessoa().getCpf());
        Assert.assertEquals(generoUsuarioEsperado, usuarioPersistido.getPessoa().getGenero());
        Assert.assertEquals(emailUsuarioEsperado, usuarioPersistido.getPessoa().getEmail());
        Assert.assertEquals(contatoUsuarioEsperado, usuarioPersistido.getPessoa().getContato());
    }

    // CT12
    @Test
    public void validaSeUsuarioEhSalvoComDadosCorretos() throws Exception {

        System.out.println("Rodando Caso de Teste: CT12");
        // Criamos e persistimos o usuario de teste
        UsuarioDao usuarioDao = new UsuarioDao();

        // Carregamos as informacoes do usuario para validacao
        Usuario usuarioPersistido = usuarioDao.getUsuario(Long.parseLong("1"));
        String nomeUsuarioEsperado = "Jorge Antônio";
        String emailUsuarioEsperado = "jorge@teste.com";
        String senhaUsuarioEsperado = "senhaacesso";
        String situacaoUsuarioEsperado = "A";

        // Aplicamos as validacoes
        Assert.assertNotNull(usuarioPersistido);
        Assert.assertEquals(nomeUsuarioEsperado, usuarioPersistido.getPessoa().getNome());
        Assert.assertEquals(emailUsuarioEsperado, usuarioPersistido.getPessoa().getEmail());
        Assert.assertEquals(senhaUsuarioEsperado, usuarioPersistido.getSenha());
        Assert.assertEquals(situacaoUsuarioEsperado, usuarioPersistido.getSituacao());
    }

    // CT13
    @Test
    public void validaSeAltaracaoDeUsuarioPersisteNoBd() throws Exception {

        System.out.println("Rodando Caso de Teste: CT13");
        // Criamos e persistimos o usuario de teste
        UsuarioDao usuarioDao = new UsuarioDao();

        // Alteramos a senha e situacao do usuario
        Usuario usuarioAlterado = usuarioDao.getUsuario(Long.parseLong("1"));
        usuarioAlterado.setSenha("novasenha");
        usuarioAlterado.setSituacao("I");
        usuarioDao.modifyUsuario(usuarioAlterado);

        // Carregamos as informacoes do usuario para validacao
        Usuario usuarioPersistido = usuarioDao.getUsuario(Long.parseLong("1"));
        String senhaUsuarioEsperado = "novasenha";
        String situacaoUsuarioEsperado = "I";

        // Aplicamos as validacoes
        Assert.assertNotNull(usuarioPersistido);
        Assert.assertEquals(senhaUsuarioEsperado, usuarioPersistido.getSenha());
        Assert.assertEquals(situacaoUsuarioEsperado, usuarioPersistido.getSituacao());
    }

    // CT14
    @Test
    public void validaSeExclusaoDoUsuarioPersisteNoBd() throws Exception {

        System.out.println("Rodando Caso de Teste: CT14");
        // Criamos e persistimos o usuario de teste
        UsuarioDao usuarioDao = new UsuarioDao();

        // Deletamos o usuario
        Usuario usuarioPersistido = usuarioDao.getUsuario(Long.parseLong("1"));
        usuarioDao.deleteUsuario(usuarioPersistido);
        Usuario usuarioDeletado = usuarioDao.getUsuario(Long.parseLong("1"));

        // Aplicamos as validacoes
        Assert.assertNotNull(usuarioPersistido);
        Assert.assertNull(usuarioDeletado);
    }
}