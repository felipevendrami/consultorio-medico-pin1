import DAO.AcessoBD;
import DAO.PessoaDao;
import DAO.UsuarioDao;
import Model.Endereco;
import Model.Pessoa;
import Model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author felip
 */
public class UsuarioDaoIntegracaoTest {

    // Mocamos os nossas pessoas de teste
    @Mock
    Pessoa pessoa1 = new Pessoa("Valdemar da Costa", Long.parseLong("98765432100"), "M", "valdemar@teste.com", Long.parseLong("11777777777"), new Endereco(0125000, "Bairro Pacaembu", "Rua de asfalto", "São Paulo", 1122, "SP", "Alm Major Vieira"));
    Pessoa pessoa2 = new Pessoa("Jorge Antônio", Long.parseLong("12345678999"), "M", "jorge@teste.com", Long.parseLong("47999999999"), new Endereco(89140000, "Bairro Teste", "", "Ibirama", 999, "SC", "Rua Teste"));


    @Before
    public void before(){
        // Instanciamos o banco H2 para o escopo de testes
        AcessoBD.setPersistenseUnitTest();

        // Persistimos as pessoas de teste
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.addPessoa(pessoa1);
        pessoaDao.addPessoa(pessoa2);

    }

    @Test
    public void validaSeUsuarioSalvoEstaRelacionadoAPessoaCorreta() throws Exception{

        System.out.println("Rodando Caso de Teste: CT11");
        // Criamos e pessistimos o usuario de teste
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario(pessoa2, "senhaacesso", "A");
        usuarioDao.addUsuario(usuario);

        // Carregamos as informacoes do usuario para validacao
        Usuario usuarioPersistido = usuarioDao.getUsuario(Long.parseLong("1"));
        String nomeUsuarioPersistido = usuarioPersistido.getPessoa().getNome();
        Long cpfUsuarioPersistido = usuarioPersistido.getPessoa().getCpf();
        String generoUsuarioPersistido = usuarioPersistido.getPessoa().getGenero();
        String emailUsuarioPersistido = usuarioPersistido.getPessoa().getEmail();
        Long contatoUsuarioPersistido = usuarioPersistido.getPessoa().getContato();
        Endereco enderecoUsuarioPersistido = usuarioPersistido.getPessoa().getEndereco();

        // Aplicamos as validacoes
        Assert.assertNotNull(usuarioPersistido.getPessoa());
        Assert.assertEquals(pessoa2.getNome(), nomeUsuarioPersistido);
        Assert.assertEquals(pessoa2.getCpf(), cpfUsuarioPersistido);
        Assert.assertEquals(pessoa2.getGenero(), generoUsuarioPersistido);
        Assert.assertEquals(pessoa2.getEmail(), emailUsuarioPersistido);
        Assert.assertEquals(pessoa2.getContato(), contatoUsuarioPersistido);
        Assert.assertEquals(pessoa2.getEndereco(), enderecoUsuarioPersistido);
    }
}
