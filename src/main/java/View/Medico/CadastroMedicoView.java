/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Medico;

import Controller.Observer.UsuarioObserver;
import View.Medico.*;
import Controller.Observer.MedicoObserver;
import Controller.MedicoController;
import Model.Endereco;
import Model.Medico;
import Model.Pessoa;
import TableModel.MedicoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Listas.ListaPessoasView;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class CadastroMedicoView extends javax.swing.JFrame implements MedicoObserver{

    /**
     * Creates new form ConsultaMedicosView
     */
    
    private MedicoController medicoController;
    
    public CadastroMedicoView(MedicoController medicoController) {
        initComponents();
        this.medicoController = medicoController;
        this.medicoController.addViewObserver(this);
        addAcoes();
        
    }

    private void addAcoes(){
        btListarPessoas.addActionListener(e -> {
            try {
                ListaPessoasView listaPessoasView = new ListaPessoasView(medicoController);
                listaPessoasView.setVisible(true);
            } catch (Exception ex) {
            }
        });
        btConfirmar.addActionListener(e -> {
            try {
                validaCampos();
                medicoController.validaData(tfDataInscricao.getText());
                medicoController.gravarMedico(montaMedico());
                setVisible(false);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
       btVoltar.addActionListener(e -> {
            setVisible(false);
        });
    }
    
    private void validaCampos() throws Exception{
        if(tfPessoa.getText().isBlank()){
            throw new Exception("Campo \"Pessoa\" é obrigatório.");
        } else if (tfEspecialidade.getText().isBlank()){
            throw new Exception("Campo \"Especialidade\" é obrigatório.");
        } else if (tfCrm.getText().isBlank()){
            throw new Exception("Selecione o campo \"CRM\".");
        } else if (tfDataInscricao.getText().isBlank()){
            throw new Exception("Campo \"Data de Inscrição\" é obrigatório.");
        } else if (tfSituacao.getText().isBlank()){
            throw new Exception("Campo \"Situação\" é obrigatório.");
        } else if (tfSenhaAcesso.getText().isBlank()){
            throw new Exception("Campo \"Senha de Acesso\" é obrigatório.");
        }
    }
    
    public Medico montaMedico() throws ParseException {
        Medico medico = new Medico(null, tfCrm.getText(), tfDataInscricao.getText(), tfSituacao.getText(), tfEspecialidade.getText());
        return medico;
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
        tfPessoa = new javax.swing.JTextField();
        tfEspecialidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDataInscricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfSituacao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfSenhaAcesso = new javax.swing.JTextField();
        tfCrm = new javax.swing.JTextField();
        btListarPessoas = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Cadastro Pessoa");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Médicos");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("> Cadastro de Médico");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jpGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpGeral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Pessoa:");

        tfPessoa.setEditable(false);
        tfPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfEspecialidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Especialidade:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CRM:");

        tfDataInscricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Data de Inscrição:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Situação:");

        tfSituacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Senha de Acesso:");

        tfSenhaAcesso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfCrm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btListarPessoas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btListarPessoas.setText("Lista");

        javax.swing.GroupLayout jpGeralLayout = new javax.swing.GroupLayout(jpGeral);
        jpGeral.setLayout(jpGeralLayout);
        jpGeralLayout.setHorizontalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeralLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGeralLayout.createSequentialGroup()
                        .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addComponent(tfEspecialidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataInscricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSenhaAcesso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addComponent(tfCrm, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(123, 123, 123))
                    .addGroup(jpGeralLayout.createSequentialGroup()
                        .addComponent(tfPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btListarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        jpGeralLayout.setVerticalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeralLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListarPessoas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfDataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfSenhaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btListarPessoas;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpGeral;
    private javax.swing.JTextField tfCrm;
    private javax.swing.JTextField tfDataInscricao;
    private javax.swing.JTextField tfEspecialidade;
    private javax.swing.JTextField tfPessoa;
    private javax.swing.JTextField tfSenhaAcesso;
    private javax.swing.JTextField tfSituacao;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirMensagem(String msg) {
        //JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarMedicos(MedicoTableModel tableModel) {
        // SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaMedico(Medico medico) {
        // SEM IMPLEMENTRAÇÃO
    }
    
    @Override
    public void retornaPessoa(Pessoa pessoa) {
        tfPessoa.setText(pessoa.getNome());
    }
}
