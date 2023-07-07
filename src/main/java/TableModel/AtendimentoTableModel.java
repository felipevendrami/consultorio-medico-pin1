/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Atendimento;
import Model.Medico;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class AtendimentoTableModel extends AbstractTableModel{

    private List<Atendimento> atendimento;
    private final String[] COLUNAS = {"Id", "Medico", "Agendamento"};
    private final int COLUNA_ID = 0;
    private final int COLUNA_MEDICO = 1;
    private final int COLUNA_AGENDAMENTO = 2;

    public AtendimentoTableModel(List<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }
    
    @Override
    public int getRowCount() {
        return this.atendimento.size();
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
        Atendimento atendimento = this.atendimento.get(rowIndex);
        return switch (columnIndex) {
            case COLUNA_ID -> String.valueOf(atendimento.getIdAtendimento());
            case COLUNA_MEDICO -> String.valueOf(atendimento.getMedico());
            case COLUNA_AGENDAMENTO -> String.valueOf(atendimento.getAgendamento());
            default -> null;
        };
    }
    
}
