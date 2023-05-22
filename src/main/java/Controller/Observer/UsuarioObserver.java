/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.Observer;

import Model.Usuario;
import TableModel.UsuarioTableModel;

/**
 *
 * @author felip
 */
public interface UsuarioObserver {
    
    void exibirMensagem(String msg);
    void listarUsuarios(UsuarioTableModel tableModel);
    void retornaUsuario(Usuario usuario);
    
}
