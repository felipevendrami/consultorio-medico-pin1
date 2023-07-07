/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Atendimento;

import View.Atendimento.*;
import View.Atendimento.*;
import Controller.Observer.AtendimentoObserver;
import Controller.AtendimentoController;
import Model.Endereco;
import Model.Atendimento;
import Model.Medico;
import Model.Pessoa;
import TableModel.AtendimentoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class AlteraAtendimentoView extends javax.swing.JFrame implements AtendimentoObserver {

    /**
     * Creates new form ConsultaAtendimentosView
     */
    private AtendimentoController atendimentoController;

    public AlteraAtendimentoView(AtendimentoController atendimentoController, Long idAtendimento) {
        initComponents();
        this.atendimentoController = atendimentoController;
        this.atendimentoController.addViewObserver(this);
        try {
            this.atendimentoController.buscaAtendimento(idAtendimento);
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        addAcoes();
    }

    private void addAcoes() {
        btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validaCampos();
                    atendimentoController.modificaAtendimento(montaAtendimento());
                    setVisible(false);
                } catch (Exception ex) {
                    exibirMensagem(ex.getMessage());
                }
            }

        });
        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private Atendimento montaAtendimento() throws ParseException {
        Date dataAtual = new Date();
        Atendimento atendimento = new Atendimento(null, null, tfSintomas.getText() , tfAlergia.getText(), tfDiagnostico.getText(), tfData.getText(), tfSintomas.getText());
        return atendimento;
    }

    private void validaCampos() throws Exception {
        if (tfMedico.getText().isBlank()) {
            throw new Exception("Campo \"Medico\" é obrigatório.");
        } else if (tfSintomas.getText().isBlank()) {
            throw new Exception("Campo \"Sintomas\" é obrigatório.");
        } else if (tfDiagnostico.getText().isBlank()) {
            throw new Exception("O campo Diagnóstico\"Diagnóstico\".");
        } else if (tfData.getText().isBlank()) {
            throw new Exception("Campo \"Data\" é obrigatório.");
        }
    }

    // private Atendimento montaAtendimento() {
    //Atendimento atendimento = new Atendimento(tfNome.getText(), Long.parseLong(tfCpf.getText()), getGenero(), tfEmail.getText(), Long.parseLong(tfContato.getText()), montaEndereco());
    //return atendimento;
    //}
    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarAtendimentos(AtendimentoTableModel tableModel) {
        // SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaAtendimento(Atendimento atendimento) {
        tfMedico.setText(atendimento.getMedico().getPessoa().getNome());
        tfAlergia.setText(atendimento.getAlergia());
        tfDiagnostico.setText(atendimento.getDiagnostico());
        tfProcedimento.setText(atendimento.getProcedimento());
        tfSintomas.setText(atendimento.getSintoma());   
    }

    @Override
    public void retornaMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpGeral = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfAgendamento = new javax.swing.JTextField();
        tfProcedimento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfSintomas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfAlergia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfDiagnostico = new javax.swing.JTextField();
        tfData = new javax.swing.JTextField();
        btListarMedicos = new javax.swing.JButton();
        tfMedico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Alterar Pessoa");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Atendimento");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("> Cadastro Atendimento");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jpGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpGeral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Medico:");

        tfAgendamento.setEditable(false);
        tfAgendamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAgendamentoActionPerformed(evt);
            }
        });

        tfProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProcedimentoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Procedimento:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data:");

        tfSintomas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSintomasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Sintomas:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Alergias:");

        tfAlergia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Diagnóstico:");

        tfDiagnostico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btListarMedicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btListarMedicos.setText("Lista");
        btListarMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarMedicosActionPerformed(evt);
            }
        });

        tfMedico.setEditable(false);
        tfMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMedicoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Agendamento:");

        javax.swing.GroupLayout jpGeralLayout = new javax.swing.GroupLayout(jpGeral);
        jpGeral.setLayout(jpGeralLayout);
        jpGeralLayout.setHorizontalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeralLayout.createSequentialGroup()
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGeralLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDiagnostico))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeralLayout.createSequentialGroup()
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpGeralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeralLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(12, 12, 12)))
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAlergia)
                            .addGroup(jpGeralLayout.createSequentialGroup()
                                .addComponent(tfMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(btListarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfProcedimento)
                            .addComponent(tfData)
                            .addComponent(tfAgendamento))
                        .addGap(18, 18, 18)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tfSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );
        jpGeralLayout.setVerticalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeralLayout.createSequentialGroup()
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpGeralLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeralLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btListarMedicos)
                            .addComponent(tfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(tfDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Geral", jpGeral);

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btConfirmar.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btConfirmar))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btConfirmar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAgendamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAgendamentoActionPerformed

    private void tfProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProcedimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProcedimentoActionPerformed

    private void tfSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSintomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSintomasActionPerformed

    private void btListarMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btListarMedicosActionPerformed

    private void tfMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMedicoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btListarMedicos;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpGeral;
    private javax.swing.JTextField tfAgendamento;
    private javax.swing.JTextField tfAlergia;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfDiagnostico;
    private javax.swing.JTextField tfMedico;
    private javax.swing.JTextField tfProcedimento;
    private javax.swing.JTextField tfSintomas;
    // End of variables declaration//GEN-END:variables

}
