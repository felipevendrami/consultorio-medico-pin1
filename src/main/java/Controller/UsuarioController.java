/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.UsuarioObserver;
import DAO.UsuarioDao;
import TableModel.UsuarioTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class UsuarioController {
    
    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<UsuarioObserver> usuarioView = new ArrayList<>();
    private UsuarioTableModel usuarioTableModel;
    
    public void addViewObserver(UsuarioObserver obs){
        this.usuarioView.add(obs);
    }

/*    
    public void gravarPessoa(Pessoa pessoa) throws Exception {
        pessoaDao.addPessoa(pessoa);
        for(PessoaObserver view : pessoaView){
            view.exibirMensagem("Pessoa cadastrada com sucesso !");
            preencherTabelaPessoa();
        }
    }*/

    public void preencherTabelaUsuario() throws Exception {
        List usuarios = usuarioDao.getTodosUsuarios();
        usuarioTableModel = new UsuarioTableModel(usuarios);
        for (UsuarioObserver view : usuarioView) {
            view.listarUsuarios(usuarioTableModel);
        }
    }
    /*
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
*/
}
