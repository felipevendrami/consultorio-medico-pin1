/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import View.MenuMedicoView;
import View.MenuUsuarioView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author felip
 */
public class Run {
    
    /*public EntityManagerFactory emf = Persistence.createEntityManagerFactory("consultorio_consultorio-medico-pin1_jar_1.0-SNAPSHOTPU");
    public EntityManager em = emf.createEntityManager();*/
    
    public static void main(String[] args) {
        
        MenuUsuarioView menuUsuarioView = new MenuUsuarioView();
        menuUsuarioView.setVisible(true);
        
        /*MenuMedicoView mv = new MenuMedicoView();
        mv.setVisible(true);*/
        
    }
}
