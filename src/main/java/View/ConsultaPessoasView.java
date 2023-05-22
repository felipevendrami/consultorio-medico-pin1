/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Observer.PessoaObserver;
import Controller.PessoaController;
import Model.Pessoa;
import TableModel.PessoaTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class ConsultaPessoasView extends javax.swing.JFrame implements PessoaObserver{

    private final PessoaController pessoaController;
    
    public ConsultaPessoasView() {
        initComponents();
        this.pessoaController = new PessoaController();
        pessoaController.addViewObserver(this);
        try {
            pessoaController.preencherTabelaPessoa();
            addAcoes();
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }
    
    private void addAcoes(){
        btCadastrar.addActionListener(e -> {
            CadastroPessoaView cadPessoaView = new CadastroPessoaView(pessoaController);
            cadPessoaView.setVisible(true);
        });
        btAlterar.addActionListener(e -> {
            try {
                AlteraPessoaView alteraPessoaView = new AlteraPessoaView(pessoaController, getIdPessoa());
                alteraPessoaView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVisualizar.addActionListener(e -> {
            try {
                VisualizaPessoaView visualizaPessoaView = new VisualizaPessoaView(pessoaController, getIdPessoa());
                visualizaPessoaView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btDeletar.addActionListener(e -> {
            try {
                this.pessoaController.excluirPessoa(getIdPessoa());
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVoltar.addActionListener(e -> setVisible(false));
    }

    public Long getIdPessoa() throws Exception{
        if(tbPessoas.getSelectedRow() == -1){
            throw new Exception("Nenhuma linha selecionada");
        } else {
            return Long.parseLong(tbPessoas.getModel().getValueAt(tbPessoas.getSelectedRow(), 0).toString());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPessoas = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Consulta Pessoas");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Pessoas");

        tbPessoas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPessoas);

        btCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");

        btAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAlterar.setText("Alterar");

        btVisualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVisualizar.setText("Visualizar");

        btDeletar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDeletar.setText("Deletar");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btVisualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btDeletar))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btAlterar)
                    .addComponent(btVisualizar)
                    .addComponent(btDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPessoas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarPessoas(PessoaTableModel tableModel) {
        tbPessoas.setModel(tableModel);
    }

    @Override
    public void retornaPessoa(Pessoa pessoa){
        // SEM IMPLEMENTAÇÃO
    }
}
