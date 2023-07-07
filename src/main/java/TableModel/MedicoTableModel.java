/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Medico;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class MedicoTableModel extends AbstractTableModel{

    private List<Medico> medicos;
    private final String[] COLUNAS = {"Id", "Pessoa", "CRM"};
    private final int COLUNA_ID = 0;
    private final int COLUNA_PESSOA = 1;
    private final int COLUNA_CRM = 2;

    public MedicoTableModel(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    @Override
    public int getRowCount() {
        return this.medicos.size();
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
        Medico medico = this.medicos.get(rowIndex);
        return switch (columnIndex) {
            case COLUNA_ID -> String.valueOf(medico.getIdMedico());
            case COLUNA_PESSOA -> String.valueOf(medico.getPessoa().getNome());
            case COLUNA_CRM -> String.valueOf(medico.getCrm());
            default -> null;
        };
    }
    
}
