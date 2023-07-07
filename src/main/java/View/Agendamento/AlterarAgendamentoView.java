/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Agendamento;

import Controller.AgendamentoController;
import Controller.Observer.AgendamentoObserver;
import Model.Agendamento;
import Model.Medico;
import Model.Pessoa;
import TableModel.AgendamentoTableModel;
import View.Listas.ListaMedicosView;
import View.Listas.ListaPessoasView;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class AlterarAgendamentoView extends javax.swing.JFrame implements AgendamentoObserver{

    /**
     * Creates new form ConsultaPessoasView
     */
    
    private AgendamentoController agendamentoController;
    
    public AlterarAgendamentoView(AgendamentoController agendamentoController, Long idAgendamento) {
        initComponents();
        this.agendamentoController = agendamentoController;
        this.agendamentoController.addViewObserver(this);
        try {
            this.agendamentoController.buscarAgendamento(idAgendamento);
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        addAcoes();
    }

    private void addAcoes(){
        btListarPessoas.addActionListener(e -> {
            try {
                ListaPessoasView listaPessoasView = new ListaPessoasView(agendamentoController);
                listaPessoasView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btListarMedicos.addActionListener(e -> {
            try {
                ListaMedicosView listaMedicosView = new ListaMedicosView(agendamentoController);
                listaMedicosView.setVisible(true);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btConfirmar.addActionListener(e -> {
            try {
                validaCampos();
                agendamentoController.validaData(tfData.getText());
                agendamentoController.modificaAgendamento(montaAgendamento());
                agendamentoController.removeViewObserver(this);
                setVisible(false);
            } catch (Exception ex) {
                exibirMensagem(ex.getMessage());
            }
        });
        btVoltar.addActionListener(e -> {
            agendamentoController.removeViewObserver(this);
            setVisible(false);
        });
    }
    
    private Agendamento montaAgendamento() throws ParseException{
        Agendamento agendamento = new Agendamento(null, taProcedimento.getText(), tfData.getText(), null);
        return agendamento;
    }
        
    private void validaCampos() throws Exception{
        if(tfPaciente.getText().isBlank()){
            throw new Exception("Você precisa selecionar uma Pessoa para prosseguir.");
        } else if (tfPaciente.getText().isBlank()){
            throw new Exception("Você precisa selecionar um Médico para prosseguir.");
        } else if (tfData.getText().isBlank()){
            throw new Exception("Campo \"Data\" é obrigatório.");
        } else if (taProcedimento.getText().isBlank()){
            throw new Exception("Campo \"Procedimento\" é obrigatório.");
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
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfPaciente = new javax.swing.JTextField();
        btListarPessoas = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfMedico = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btListarMedicos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taProcedimento = new javax.swing.JTextArea();
        tfData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema - Alterar Agendamento");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Agendamentos");

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("> Alterar Agendamento");

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btConfirmar.setText("Confirmar");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Paciente:");

        tfPaciente.setEditable(false);
        tfPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btListarPessoas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btListarPessoas.setText("Lista");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Médico:");

        tfMedico.setEditable(false);
        tfMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Agendar para:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Procedimento a realizar:");

        btListarMedicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btListarMedicos.setText("Lista");

        taProcedimento.setColumns(20);
        taProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taProcedimento.setRows(5);
        jScrollPane1.setViewportView(taProcedimento);

        tfData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btVoltar)
                                .addGap(594, 594, 594)
                                .addComponent(btConfirmar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel18)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btListarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btListarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(294, 294, 294))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListarPessoas))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListarMedicos))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btListarMedicos;
    private javax.swing.JButton btListarPessoas;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taProcedimento;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfMedico;
    private javax.swing.JTextField tfPaciente;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void listarAgendamentos(AgendamentoTableModel tableModel) {
        //SEM IMPLEMENTAÇÃO
    }

    @Override
    public void retornaPessoa(Pessoa pessoa) {
        tfPaciente.setText(pessoa.getNome());
    }

    @Override
    public void retornaMedico(Medico medico) {
        tfMedico.setText(medico.getPessoa().getNome());
    }

    @Override
    public void retornaAgendamento(Agendamento agendamento) {
        tfPaciente.setText(agendamento.getPaciente().getNome());
        tfMedico.setText(agendamento.getMedico().getPessoa().getNome());
        tfData.setText(agendamento.formatDatetoString());
        taProcedimento.append(agendamento.getProcedimento());
    }

}
