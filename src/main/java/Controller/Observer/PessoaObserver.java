/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Observer;

import Model.Pessoa;
import TableModel.PessoaTableModel;

/**
 *
 * @author felip
 */
public interface PessoaObserver{
    
    void exibirMensagem(String msg);
    void listarPessoas(PessoaTableModel tableModel);
    void retornaPessoa(Pessoa pessoa);
    
}
