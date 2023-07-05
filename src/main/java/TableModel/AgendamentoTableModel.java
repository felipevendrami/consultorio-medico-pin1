/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import Model.Agendamento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felip
 */
public class AgendamentoTableModel extends AbstractTableModel{

    private List<Agendamento> agendamentos;
    private final String[] COLUNAS = {"Id", "Paciente", "Médico", "Data", "Procedimento"};
    private final int COLUNA_ID = 0;
    private final int COLUNA_PACIENTE = 1;
    private final int COLUNA_MEDICO = 2;
    private final int COLUNA_DATA = 3;
    private final int COLUNA_PROCEDIMENTO = 4;

    public AgendamentoTableModel(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
    
    @Override
    public int getRowCount() {
        return this.agendamentos.size();
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
        Agendamento agendamento = this.agendamentos.get(rowIndex);
        return switch (columnIndex) {
            case COLUNA_ID -> String.valueOf(agendamento.getIdAgendamento());
            case COLUNA_PACIENTE -> String.valueOf(agendamento.getPaciente().getNome());
            case COLUNA_MEDICO -> String.valueOf(agendamento.getMedico().getPessoa().getNome());
            case COLUNA_DATA -> String.valueOf(agendamento.formatDatetoString());
            case COLUNA_PROCEDIMENTO -> String.valueOf(agendamento.getProcedimento());
            default -> null;
        };
    }
    
    
    
}
