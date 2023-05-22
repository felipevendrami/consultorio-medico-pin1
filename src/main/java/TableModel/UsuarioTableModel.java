/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class UsuarioTableModel extends AbstractTableModel{

    private List<Usuario> usuarios;
    private final String[] COLUNAS = {"Id", "Nome", "E-mail", "Situação"};
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_EMAIL = 2;
    private final int COLUNA_SITUACAO = 3;

    public UsuarioTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return COLUNAS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUNAS[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = this.usuarios.get(rowIndex);
        return switch (columnIndex) {
            case COLUNA_ID -> String.valueOf(usuario.getIdUsuario());
            case COLUNA_NOME -> String.valueOf(usuario.getPessoa().getNome());
            case COLUNA_EMAIL -> String.valueOf(usuario.getPessoa().getEmail());
            case COLUNA_SITUACAO -> String.valueOf(usuario.getSituacao());
            default -> null;
        };
    }
    
}
