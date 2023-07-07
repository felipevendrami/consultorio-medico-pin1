/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.ListObserver;
import Controller.Observer.MedicoObserver;
import DAO.MedicoDao;
import Model.Medico;
import Model.Pessoa;
import TableModel.MedicoTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author felip
 */
public class MedicoController  implements ListObserver{

    private MedicoDao medicoDao = new MedicoDao();
    private List<MedicoObserver> medicoView = new ArrayList<>();
    private MedicoTableModel medicoTableModel;
    private Pessoa pessoaSelecionada;
    private Medico ModelMedico;

    public void addViewObserver(MedicoObserver obs) {
        this.medicoView.add(obs);
    }

    public void removeViewObserver(MedicoObserver obs){
        this.medicoView.remove(obs);
    }
    
    public void gravarMedico(Medico medico) throws Exception {
        medico.setPessoa(pessoaSelecionada);
        medicoDao.addMedico(medico);
        for(MedicoObserver view : medicoView){
            view.exibirMensagem("Medico cadastrado com sucesso !");
            preencherTabelaMedico();
        }
    }

    public void preencherTabelaMedico() throws Exception {
        List medicos = medicoDao.getTodosMedicos();
        medicoTableModel = new MedicoTableModel(medicos);
        for (MedicoObserver view : medicoView) {
            view.listarMedicos(medicoTableModel);
        }
    }
    
    public void buscaMedico(Long idMedico) throws Exception{
        ModelMedico = medicoDao.getMedico(idMedico);
        this.pessoaSelecionada = ModelMedico.getPessoa();
        for(MedicoObserver view : medicoView){
            view.retornaMedico(ModelMedico);
        }
    }
    
    public void modificaMedico(Medico medicoMod) throws Exception{
        medicoMod.setPessoa(pessoaSelecionada);
        medicoMod.setIdMedico(ModelMedico.getIdMedico());
        medicoDao.modifyMedico(medicoMod);
        preencherTabelaMedico();
        for(MedicoObserver view : medicoView){
            view.exibirMensagem("Medico alterado com sucesso !");
        }
    }
    
    public void excluirMedico(Long idMedico) throws Exception{
        Medico medico = medicoDao.getMedico(idMedico);
        medicoDao.deleteMedico(medico);
        preencherTabelaMedico();
        for(MedicoObserver view : medicoView){
            view.exibirMensagem("Medico excluído com sucesso !");
        }
    }

    public void validaData(String data) throws Exception {
        //Validamos se a data informada pelo usuário está no padrão
        String padrao = "\\d{2}/\\d{2}/\\d{4}";
        Pattern padraoData = Pattern.compile(padrao);
        Matcher matcher = padraoData.matcher(data);
        if(!matcher.matches()){
            throw new Exception("O campo \"Data\" não está no formato correto. Exemplo \"12/10/2023\".");
        }
    }

    @Override    
    public void retornaObjeto(Object obj) {
        if(obj instanceof Pessoa){
            this.pessoaSelecionada = (Pessoa) obj;
            for(MedicoObserver view : medicoView){
                view.retornaPessoa(pessoaSelecionada);
            }
        }
    }
}
