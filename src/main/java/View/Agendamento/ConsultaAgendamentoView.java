/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Agendamento;

import Controller.AgendamentoController;
import Controller.AtendimentoController;
import Controller.Observer.AgendamentoObserver;
import Model.Agendamento;
import Model.Medico;
import Model.Pessoa;
import TableModel.AgendamentoTableModel;
import View.Atendimento.CadastroAtendimentoView;
import javax.swing.JOptionPane;


/**
 *
 * @author felip
 */
public class ConsultaAgendamentoView extends javax.swing.JFrame implements AgendamentoObserver{

    private AgendamentoController agendamentoController;
    public AtendimentoController atendimentoController;
    
    public ConsultaAgendamentoView() {
        initComponents();
        this.agendamentoController = new AgendamentoController();
        agendamentoController.addViewObserver(this);
        try {
            agendamentoController.preencherTabelaAgendamento();
            addAcoes();
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
    }
    
    private void addAcoes(){
        btNovoAtendimento.addActionListener(e -> {
            NovoAgendamentoView novoAgendamentoView = new NovoAgendamentoView(agendamentoController);
            novoAgendamentoView.setVisible(true);
        });
        btAlterar.addActionListener(e -> {
            try {
                AlterarAgendamentoView alterarAgendamentoView = new AlterarAgendamentoView(agendamentoController, getIdAgendamento());
                alterarAgendamentoView.setVisible(true);
            } catch (Exception ex){
                exibirMensagem(ex.getMessage());
            } 
        });
        btVisualizar.addActionListener(e -> {
            try {
                VisualizarAgendamentoView visualizarAgendamentoView = new VisualizarAgendamentoView(agendamentoController, getIdAgendamento());
                visualizarAgendamentoView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btDeletar.addActionListener(e -> {
            try {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar o Agentamento selecionado ?", "Pergunta", 0);
                if(opcao == 0){
                    this.agendamentoController.excluirAgendamento(getIdAgendamento());
                }
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVoltar.addActionListener(e -> {
            agendamentoController.removeViewObserver(this);
            setVisible(false);
        });
        
        btAtendimento.addActionListener(e -> {
            try {
                CadastroAtendimentoView cadastroAtendimentoView = new CadastroAtendimentoView(null, getIdAgendamento());
                cadastroAtendimentoView.setVisible(true);
            } catch (Exception ex){
                exibirMensagem(ex.getMessage());
            } 
        });
    }
    
    public Long getIdAgendamento() throws Exception{
        if(tbAgendamentos.getSelectedRow() == -1){
            throw new Exception("Nenhuma linha selecionada");
        } else {
            return Long.parseLong(tbAgendamentos.getModel().getValueAt(tbAgendamentos.getSelectedRow(), 0).toString());
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
        tbAgendamentos = new javax.swing.JTable();
        btNovoAtendimento = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btAtendimento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Consulta Agendamentos");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Agendamentos");

        tbAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbAgendamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbAgendamentos);

        btNovoAtendimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btNovoAtendimento.setText("Novo Atendimento");

        btAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAlterar.setText("Alterar");

        btVisualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVisualizar.setText("Visualizar");

        btDeletar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDeletar.setText("Deletar");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");

        btAtendimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAtendimento.setText("Atendimento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovoAtendimento)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btVisualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(btAtendimento))
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
                    .addComponent(btNovoAtendimento)
                    .addComponent(btAlterar)
                    .addComponent(btVisualizar)
                    .addComponent(btDeletar)
                    .addComponent(btAtendimento))
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

    private javax.swing.JButton btAtendimento;

    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btNovoAtendimento;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAgendamentos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarAgendamentos(AgendamentoTableModel tableModel) {
        tbAgendamentos.setModel(tableModel);
    }

    @Override
    public void retornaPessoa(Pessoa pessoa) {
        //SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaMedico(Medico medico) {
        //SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaAgendamento(Agendamento agendamento) {
        //SEM IMPLEMENTAÇÃO
    }
}
