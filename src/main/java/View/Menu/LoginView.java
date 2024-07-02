/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Menu;

import Controller.LoginController;
import Controller.Observer.LoginObserver;

import javax.swing.*;

/**
 *
 * @author felip
 */
public class LoginView extends javax.swing.JFrame implements LoginObserver{

    /**
     * Creates new form Login
     */
    
    private LoginController loginController;
    
    public LoginView() {
        initComponents();
        this.loginController = new LoginController();
        this.loginController.setViewObserver(this);
        addAcoes();
    }

    private void addAcoes(){
        btLogin.addActionListener(e -> {
            try {
                //validaCampos();
                //loginController.autenticarUsuario(tfUsuario.getText(), pfSenha.getText());
                autenticaUsuario();
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
    }


    public void autenticaUsuario() throws Exception {
        try{
            validaCampos();
            this.loginController.autenticarUsuario(tfUsuario.getText(), pfSenha.getText());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
    private void validaCampos() throws Exception{
        if(tfUsuario.getText().isBlank()){
            throw new Exception("Campo \"E-mail\" é obrigatório.");
        } else if (pfSenha.getText().isBlank()){
            throw new Exception("Campo \"Senha\" é obrigatório.");
        }
    }

    public void setPfSenha(String pfSenha) {
        JPasswordField jPasswordField = new JPasswordField(pfSenha);
        this.pfSenha = jPasswordField;
    }

    public void setTfUsuario(String tfUsuario) {
        JTextField jtextField = new JTextField(tfUsuario);
        this.tfUsuario = jtextField;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema - Login");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CLÍNICA WHITE HOUSE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("E-mail:");

        tfUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Senha:");

        pfSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btLogin.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsuario)
                            .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btLogin)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btLogin)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void authUsuarioMedico() {
        setVisible(false);
        MenuMedicoView menuMedico = new MenuMedicoView();
        menuMedico.setVisible(true);
    }

    @Override
    public void authUsuario() {
        setVisible(false);
        MenuUsuarioView menuUsuario = new MenuUsuarioView();
        menuUsuario.setVisible(true);
    }
}
