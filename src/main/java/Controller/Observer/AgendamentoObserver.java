/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Observer;

import Model.Medico;
import Model.Pessoa;
import TableModel.AgendamentoTableModel;

/**
 *
 * @author felip
 */
public interface AgendamentoObserver {
    
    void exibirMensagem(String msg);
    void listarAgendamentos(AgendamentoTableModel tableModel);
    void retornaPessoa(Pessoa pessoa);
    void retornaMedico(Medico medico);
}
