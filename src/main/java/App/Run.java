/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import View.Menu.LoginView;
import View.Menu.MenuUsuarioView;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class Run {
    
    public static void main(String[] args) {
        
        /*MenuUsuarioView menuUsuarioView = new MenuUsuarioView();
        menuUsuarioView.setVisible(true);*/
        
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
