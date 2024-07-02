import DAO.AcessoBD;
import View.Menu.LoginView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class LoginViewSystemTest{

    @Mock
    LoginView loginView = new LoginView();

    @Before
    public void before(){
        AcessoBD.setPersistenseUnitProd();
    }

    // CT15
    @Test
    public void campoEmailInformadoInvalido(){

        System.out.println("Rodando Caso de Teste: CT15");

        String email = "felipe@test.com";
        String senha = "testesenha";

        this.loginView.setTfUsuario(email);
        this.loginView.setPfSenha(senha);

        try {
            this.loginView.autenticaUsuario();
            Assert.fail("Esperava-se uma Excepition: \"Verifique as suas credenciais.\"");
        } catch (Exception e) {
            Assert.assertEquals("Verifique as suas credenciais.", e.getMessage());
        }
    }

    // CT16
    @Test
    public void campoSenhaInformadoInvalido(){

        System.out.println("Rodando Caso de Teste: CT16");

        String email = "felipe@teste.com";
        String senha = "testsenha";

        this.loginView.setTfUsuario(email);
        this.loginView.setPfSenha(senha);

        try {
            this.loginView.autenticaUsuario();
            Assert.fail("Esperava-se uma Excepition: \"Verifique as suas credenciais.\"");
        } catch (Exception e) {
            Assert.assertEquals("Verifique as suas credenciais.", e.getMessage());
        }
    }

    // CT17
    @Test
    public void loginRealizadComSucesso(){

        System.out.println("Rodando Caso de Teste: CT17");

        String email = "felipe@teste.com";
        String senha = "testesenha";

        this.loginView.setTfUsuario(email);
        this.loginView.setPfSenha(senha);

        try {
            this.loginView.autenticaUsuario();
        } catch (Exception e) {
            Assert.fail("Esperava-se nenhuma Excepition: Exception: " + e.getMessage());
        }
    }
}
