/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Listas;

import Controller.Observer.PessoaObserver;
import Controller.PessoaController;
import Model.Pessoa;
import TableModel.PessoaTableModel;
import javax.swing.JOptionPane;
import Controller.Observer.ListObserver;

/**
 *
 * @author felip
 */
public class ListaPessoasView extends javax.swing.JFrame implements PessoaObserver{

    private PessoaController pessoaController;
    private ListObserver controllerRetorno;
     
    public ListaPessoasView(ListObserver viewRetorno) {
        initComponents();
        this.pessoaController = new PessoaController();
        this.pessoaController.addViewObserver(this);
        this.controllerRetorno = viewRetorno;
        try {
            pessoaController.preencherTabelaPessoa();
            addAcoes();
       } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }
    
    private void addAcoes(){
        btSelecionar.addActionListener(e ->{
            try {
                this.pessoaController.buscaPessoa(getIdPessoa());
                this.setVisible(false);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btFechar.addActionListener(e -> {
            setVisible(false);
        });
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
        btFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Lista de Pessoas");
        setMinimumSize(new java.awt.Dimension(430, 500));
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

        btFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btFechar.setText("Fechar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("> Lista de Pessoas");

        btSelecionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSelecionar.setText("Selecionar");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btFechar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btSelecionar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btSelecionar))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPessoas;
    // End of variables declaration//GEN-END:variables

    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarPessoas(PessoaTableModel tableModel) {
        tbPessoas.setModel(tableModel);
    }

    @Override
    public void retornaPessoa(Pessoa pessoa) {
       this.controllerRetorno.retornaObjeto(pessoa);
    }
}