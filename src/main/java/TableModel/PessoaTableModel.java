/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class PessoaTableModel extends AbstractTableModel{

    private List<Pessoa> pessoas;
    private final String[] COLUNAS = {"Id", "Nome", "CPF"};
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_CPF = 2;

    public PessoaTableModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    @Override
    public int getRowCount() {
        return this.pessoas.size();
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
        Pessoa pessoa = this.pessoas.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_ID:
                valor = String.valueOf(pessoa.getId());
                break;
            case COLUNA_NOME:
                valor = String.valueOf(pessoa.getNome());
                break;
            case COLUNA_CPF:
                valor = String.valueOf(pessoa.getCpf());
                break;
        }
        return valor;
    }
    
}
