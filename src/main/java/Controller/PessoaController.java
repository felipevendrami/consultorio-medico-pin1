/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.PessoaObserver;
import DAO.PessoaDao;
import Model.Pessoa;
import TableModel.PessoaTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class PessoaController {

    private PessoaDao pessoaDao = new PessoaDao();
    private List<PessoaObserver> pessoaView = new ArrayList<>();
    private PessoaTableModel pessoaTableModel;

    public void addViewObserver(PessoaObserver obs) {
        this.pessoaView.add(obs);
    }

    public void gravarPessoa(Pessoa pessoa) throws Exception {
        pessoaDao.addPessoa(pessoa);
        for(PessoaObserver view : pessoaView){
            view.exibirMensagem("Pessoa cadastrada com sucesso !");
            preencherTabelaPessoa();
        }
    }

    public void preencherTabelaPessoa() throws Exception {
        List pessoas = pessoaDao.getTodasPessoas();
        pessoaTableModel = new PessoaTableModel(pessoas);
        for (PessoaObserver view : pessoaView) {
            view.listarPessoas(pessoaTableModel);
        }
    }
    
    public void buscaPessoa(Long idPessoa) throws Exception{
        Pessoa pessoa = pessoaDao.getPessoa(idPessoa);
        for(PessoaObserver view : pessoaView){
            view.retornaPessoa(pessoa);
        }
    }
    
    public void modificaPessoa(Pessoa pessoaMod) throws Exception{
        pessoaDao.modifyPessoa(pessoaMod);
        preencherTabelaPessoa();
        for(PessoaObserver view : pessoaView){
            view.exibirMensagem("Pessoa alterada com sucesso !");
        }
    }
    
    public void excluirPessoa(Long idPessoa) throws Exception{
        Pessoa pessoa = pessoaDao.getPessoa(idPessoa);
        pessoaDao.deletePessoa(pessoa);
        preencherTabelaPessoa();
        for(PessoaObserver view : pessoaView){
            view.exibirMensagem("Pessoa excluída com sucesso !");
        }
    }
}
