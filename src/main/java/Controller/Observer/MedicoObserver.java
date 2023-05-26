/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Observer;

import Model.Medico;
import Model.Pessoa;
import TableModel.MedicoTableModel;

/**
 *
 * @author felip
 */
public interface MedicoObserver {
    
    void exibirMensagem(String msg);
    void listarMedicos(MedicoTableModel tableModel);
    void retornaMedico(Medico medico);
    void retornaPessoa(Pessoa pessoa);
}
