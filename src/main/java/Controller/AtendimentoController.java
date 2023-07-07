/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.ListObserver;
import Controller.Observer.AtendimentoObserver;
import DAO.AtendimentoDao;
import Model.Atendimento;
import Model.Atendimento;
import Model.Atendimento;
import Model.Medico;
import TableModel.AtendimentoTableModel;
import TableModel.AtendimentoTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class AtendimentoController  implements ListObserver{

    private AtendimentoDao atendimentoDao = new AtendimentoDao();
    private List<AtendimentoObserver> atendimentoView = new ArrayList<>();
    private AtendimentoTableModel atendimentoTableModel;
    private Medico medicoSelecionado;
    private Atendimento ModelAtendimento;

    public void addViewObserver(AtendimentoObserver obs) {
        this.atendimentoView.add(obs);
    }

    public void removeViewObserver(AtendimentoObserver obs){
        this.atendimentoView.remove(obs);
    }
    
    public void gravarAtendimento(Atendimento atendimento) throws Exception {
        atendimento.setMedico(medicoSelecionado);
        atendimentoDao.addAtendimento(atendimento);
        for(AtendimentoObserver view : atendimentoView){
            view.exibirMensagem("Atendimento cadastrado com sucesso !");
            preencherTabelaAtendimento();
        }
    }

    public void preencherTabelaAtendimento() throws Exception {
        List atendimentos = atendimentoDao.getTodosAtendimentos();
        atendimentoTableModel = new AtendimentoTableModel(atendimentos);
        for (AtendimentoObserver view : atendimentoView) {
            view.listarAtendimentos(atendimentoTableModel);
        }
    }
    
    public void buscaAtendimento(Long idAtendimento) throws Exception{
        ModelAtendimento = atendimentoDao.getAtendimento(idAtendimento);
        this.medicoSelecionado = ModelAtendimento.getMedico();
        for(AtendimentoObserver view : atendimentoView){
            view.retornaAtendimento(ModelAtendimento);
        }
    }
    
    public void modificaAtendimento(Atendimento atendimentoMod) throws Exception{
        atendimentoMod.setMedico(medicoSelecionado);
        atendimentoMod.setIdAtendimento(ModelAtendimento.getIdAtendimento());
        atendimentoDao.modifyAtendimento(atendimentoMod);
        preencherTabelaAtendimento();
        for(AtendimentoObserver view : atendimentoView){
            view.exibirMensagem("Atendimento alterado com sucesso !");
        }
    }
    
    public void excluirAtendimento(Long idAtendimento) throws Exception{
        Atendimento atendimento = atendimentoDao.getAtendimento(idAtendimento);
        atendimentoDao.deleteAtendimento(atendimento);
        preencherTabelaAtendimento();
        for(AtendimentoObserver view : atendimentoView){
            view.exibirMensagem("Atendimento excluído com sucesso !");
        }
    }

    @Override    
    public void retornaObjeto(Object obj) {
        if(obj instanceof Medico){
            this.medicoSelecionado = (Medico) obj;
            for(AtendimentoObserver view : atendimentoView){
                view.retornaMedico(medicoSelecionado);
            }
        }
    }
}
