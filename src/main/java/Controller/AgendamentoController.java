/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.AgendamentoObserver;
import Controller.Observer.ListObserver;
import DAO.AgendamentoDao;
import Model.Agendamento;
import Model.Medico;
import Model.Pessoa;
import TableModel.AgendamentoTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author felip
 */
public class AgendamentoController implements ListObserver{
    
    private AgendamentoDao agendamentoDao = new AgendamentoDao();
    private List<AgendamentoObserver> agendamentoView = new ArrayList<>();
    private AgendamentoTableModel agendamentoTableModel;
    private Pessoa pessoaSelecionada;
    private Medico medicoSelecinado;
    private Agendamento ModelAgendamento;
    
    public void addViewObserver(AgendamentoObserver obs){
        this.agendamentoView.add(obs);
    }
    
    public void removeViewObserver(AgendamentoObserver obs){
        this.agendamentoView.remove(obs);
    }
    
    public void gravarAgendamento(Agendamento agendamento) throws Exception {
        agendamento.setPaciente(pessoaSelecionada);
        agendamento.setMedico(medicoSelecinado);
        agendamentoDao.addAgendamento(agendamento);
        for(AgendamentoObserver view : agendamentoView){
            view.exibirMensagem("Agendamento realizado com sucesso !");
            preencherTabelaAgendamento();
        }
    }
    
    public void preencherTabelaAgendamento() throws Exception{
        List agendamentos = agendamentoDao.getTodosAgendamentos();
        agendamentoTableModel = new AgendamentoTableModel(agendamentos);
        for(AgendamentoObserver view : agendamentoView){
            view.listarAgendamentos(agendamentoTableModel);
        }
    }

    @Override
    public void retornaObjeto(Object obj){
        if(obj instanceof Pessoa){
            this.pessoaSelecionada = (Pessoa) obj;
            for(AgendamentoObserver view : agendamentoView){
                view.retornaPessoa(pessoaSelecionada);
            }
        } else if (obj instanceof Medico){
            this.medicoSelecinado = (Medico) obj;
            for(AgendamentoObserver view : agendamentoView){
                view.retornaMedico(medicoSelecinado);
            }
        }
    }    

    public void buscarAgendamento(Long idAgendamento) throws Exception{
        ModelAgendamento = agendamentoDao.getAgendamento(idAgendamento);
        this.pessoaSelecionada = ModelAgendamento.getPaciente();
        this.medicoSelecinado = ModelAgendamento.getMedico();
        for(AgendamentoObserver view : agendamentoView){
            view.retornaAgendamento(ModelAgendamento);
        }
    }

    public void modificaAgendamento(Agendamento agendamentoMod) throws Exception{
        agendamentoMod.setPaciente(pessoaSelecionada);
        agendamentoMod.setMedico(medicoSelecinado);
        agendamentoMod.setIdAgendamento(ModelAgendamento.getIdAgendamento());
        //agendamentoMod.getPaciente().setId(ModelAgendamento.getPaciente().getId());
        //agendamentoMod.getMedico().setIdMedico(ModelAgendamento.getMedico().getIdMedico());
        agendamentoDao.modifyAgendamento(agendamentoMod);
        preencherTabelaAgendamento();
        for(AgendamentoObserver view : agendamentoView){
            view.exibirMensagem("Agendamento alterado com sucesso !");
        }
    }

    public void excluirAgendamento(Long idAgendamento) throws Exception{
        Agendamento agendamento = agendamentoDao.getAgendamento(idAgendamento);
        agendamentoDao.deleteAgendamento(agendamento);
        preencherTabelaAgendamento();
        for(AgendamentoObserver view : agendamentoView){
            view.exibirMensagem("Agendamento excluído com sucesso !");
        }
    }
    
    public void validaData(String data) throws Exception {
        //Validamos se a data informada pelo usuário está no padrão
        String padrao = "\\d{2}/\\d{2}/\\d{4}";
        Pattern padraoData = Pattern.compile(padrao);
        Matcher matcher = padraoData.matcher(data);
        if(matcher.matches()){
            //Validamos se a data não está no passado
            if(!formatStringtoDate(data).before(new Date())){
            } else {
                throw new Exception("A \"Data\" não pode estar no passado.");
            }
        } else {
            throw new Exception("O campo \"Data\" não está no formato correto. Exemplo \"12/10/2023\".");
        }
    }
    
    private Date formatStringtoDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(data);
    }
    
    public boolean validaPessoasSelecionadasIguais(){
        if((pessoaSelecionada != null) && (medicoSelecinado != null)){
            if(pessoaSelecionada != medicoSelecinado.getPessoa()){
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
