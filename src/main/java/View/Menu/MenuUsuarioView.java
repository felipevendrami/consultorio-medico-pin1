/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Menu;

import View.Agendamento.ConsultaAgendamentoView;
import View.Medico.ConsultaMedicoView;
import View.Pessoa.ConsultaPessoaView;
import View.Pessoa.ConsultaUsuarioView;

/**
 *
 * @author felip
 */
public class MenuUsuarioView extends javax.swing.JFrame {

    /**
     * Creates new form MenuUsuarioView
     */
    public MenuUsuarioView() {
        initComponents();
        addAcoes();
    }
    
    private void addAcoes(){
        btPessoas.addActionListener(e -> {
            ConsultaPessoaView consultaPessoasView = new ConsultaPessoaView();
            consultaPessoasView.setVisible(true);
        });
        btUsuarios.addActionListener(e -> {
            ConsultaUsuarioView consultaUsuarioView = new ConsultaUsuarioView();
            consultaUsuarioView.setVisible(true);
        });
        btMedicos.addActionListener(e -> {
            ConsultaMedicoView consultaMedicoView = new ConsultaMedicoView();
            consultaMedicoView.setVisible(true);
        });
        btAgendamentos.addActionListener(e -> {
            ConsultaAgendamentoView consultaAgendamentoView = new ConsultaAgendamentoView();
            consultaAgendamentoView.setVisible(true);
        });
        btLogout.addActionListener(e -> {
            setVisible(false);
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLogout = new javax.swing.JButton();
        btPessoas = new javax.swing.JButton();
        btMedicos = new javax.swing.JButton();
        btAgendamentos = new javax.swing.JButton();
        btUsuarios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema - Consultas");
        setAutoRequestFocus(false);
        setResizable(false);

        btLogout.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btLogout.setText("Logout");

        btPessoas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-group-solid (Personalizado).png"))); // NOI18N
        btPessoas.setText("Pessoas");
        btPessoas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btPessoas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPessoas.setMaximumSize(new java.awt.Dimension(160, 150));
        btPessoas.setMinimumSize(new java.awt.Dimension(160, 150));
        btPessoas.setPreferredSize(new java.awt.Dimension(160, 150));
        btPessoas.setVerifyInputWhenFocusTarget(false);
        btPessoas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btMedicos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-doctor-solid (Personalizado).png"))); // NOI18N
        btMedicos.setText("Médicos");
        btMedicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btMedicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btMedicos.setMaximumSize(new java.awt.Dimension(160, 150));
        btMedicos.setMinimumSize(new java.awt.Dimension(160, 150));
        btMedicos.setPreferredSize(new java.awt.Dimension(160, 150));
        btMedicos.setVerifyInputWhenFocusTarget(false);
        btMedicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btAgendamentos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-group-solid (Personalizado).png"))); // NOI18N
        btAgendamentos.setText("Agendamentos");
        btAgendamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAgendamentos.setMaximumSize(new java.awt.Dimension(160, 150));
        btAgendamentos.setMinimumSize(new java.awt.Dimension(160, 150));
        btAgendamentos.setPreferredSize(new java.awt.Dimension(160, 150));
        btAgendamentos.setVerifyInputWhenFocusTarget(false);
        btAgendamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgendamentosActionPerformed(evt);
            }
        });

        btUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-solid (Personalizado).png"))); // NOI18N
        btUsuarios.setText("Usuários");
        btUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btUsuarios.setMaximumSize(new java.awt.Dimension(160, 150));
        btUsuarios.setMinimumSize(new java.awt.Dimension(160, 150));
        btUsuarios.setPreferredSize(new java.awt.Dimension(160, 150));
        btUsuarios.setVerifyInputWhenFocusTarget(false);
        btUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btUsuariosActionPerformed

    private void btAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgendamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgendamentosActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgendamentos;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btMedicos;
    private javax.swing.JButton btPessoas;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
