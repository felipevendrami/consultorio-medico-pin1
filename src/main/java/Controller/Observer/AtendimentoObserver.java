/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Observer;

import Model.Atendimento;
import Model.Medico;
import TableModel.AtendimentoTableModel;

/**
 *
 * @author felip
 */
public interface AtendimentoObserver {
    
    void exibirMensagem(String msg);
    void listarAtendimentos(AtendimentoTableModel tableModel);
    void retornaAtendimento(Atendimento atendimento);
    void retornaMedico(Medico medico);
}
