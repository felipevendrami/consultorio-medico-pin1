/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.LoginObserver;
import DAO.UsuarioDao;

/**
 *
 * @author felip
 */
public class LoginController {
    
    private LoginObserver loginView;
    private UsuarioDao usuarioDao = new UsuarioDao();

    public void setViewObserver(LoginObserver obs){
        this.loginView = obs;
    }
    
    public void autenticarUsuario(String email, String senha) throws Exception{
        if(usuarioDao.authenticateMedico(email, senha)){
            loginView.exibirMensagem("Médico autenticado com sucesso !");
            loginView.authUsuarioMedico();
        } else if (usuarioDao.authenticateUsuario(email, senha)){
            loginView.exibirMensagem("Usuário autenticado com sucesso !");
            loginView.authUsuario();
        } else {
            throw new Exception ("Verifique as suas credenciais.");
        }
    }
    
}
