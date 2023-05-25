/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Pessoa;

import Controller.Observer.UsuarioObserver;
import Controller.UsuarioController;
import Model.Pessoa;
import Model.Usuario;
import TableModel.UsuarioTableModel;
import View.Usuario.AlteraUsuarioView;
import View.Usuario.CadastroUsuarioView;
import View.Usuario.VisualizaUsuarioView;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class ConsultaUsuarioView extends javax.swing.JFrame implements UsuarioObserver{
    
    private UsuarioController usuarioController;
    
    public ConsultaUsuarioView() {
        initComponents();
        this.usuarioController = new UsuarioController();
        this.usuarioController.addViewObserver(this);
        try {
            usuarioController.preencherTabelaUsuario();
            addAcoes();
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }
    
    private void addAcoes(){
        btCadastrar.addActionListener(e -> {
            CadastroUsuarioView cadUsuarioView = new CadastroUsuarioView(usuarioController);
            cadUsuarioView.setVisible(true);
        });
        btAlterar.addActionListener(e -> {
            try {
                AlteraUsuarioView alteraUsuarioView = new AlteraUsuarioView(usuarioController, getIdUsuario());
                alteraUsuarioView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVisualizar.addActionListener(e -> {
            try {
                VisualizaUsuarioView visualizaUsuarioView = new VisualizaUsuarioView(usuarioController, getIdUsuario());
                visualizaUsuarioView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btDeletar.addActionListener(e -> {
            try {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar o Usuário selecionado ?", "Pergunta", 0);
                if(opcao == 0){
                    this.usuarioController.excluirUsuario(getIdUsuario());
                }
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVoltar.addActionListener(e -> {
            setVisible(false);
        });
    }
    
    public Long getIdUsuario() throws Exception{
        if(tbUsuarios.getSelectedRow() == -1){
            throw new Exception("Nenhuma linha selecionada");
        } else {
            return Long.parseLong(tbUsuarios.getModel().getValueAt(tbUsuarios.getSelectedRow(), 0).toString());
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
        tbUsuarios = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Consulta Usuários");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Usuários");

        tbUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbUsuarios);

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
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarUsuarios(UsuarioTableModel tableModel) {
        tbUsuarios.setModel(tableModel);
    }

    @Override
    public void retornaUsuario(Usuario usuario) {
        //SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaPessoa(Pessoa pessoa) {
        // SEM IMPLEMENTAÇÃO
    }
}