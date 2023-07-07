/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Observer.ListObserver;
import Controller.Observer.UsuarioObserver;
import DAO.UsuarioDao;
import Model.Pessoa;
import Model.Usuario;
import TableModel.UsuarioTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class UsuarioController implements ListObserver{
    
    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<UsuarioObserver> usuarioView = new ArrayList<>();
    private UsuarioTableModel usuarioTableModel;
    private Pessoa pessoaSelecionada;
    private Usuario ModelUsuario;
    
    public void addViewObserver(UsuarioObserver obs){
        this.usuarioView.add(obs);
    }

 
    public void gravarUsuario(Usuario usuario) throws Exception {
        usuario.setPessoa(pessoaSelecionada);
        usuarioDao.addUsuario(usuario);
        for(UsuarioObserver view : usuarioView){
            view.exibirMensagem("Usuário cadastrado com sucesso !");
            preencherTabelaUsuario();
        }
    }

    public void preencherTabelaUsuario() throws Exception {
        List usuarios = usuarioDao.getTodosUsuarios();
        usuarioTableModel = new UsuarioTableModel(usuarios);
        for (UsuarioObserver view : usuarioView) {
            view.listarUsuarios(usuarioTableModel);
        }
    }
    
    public void buscaUsuario(Long idUsuario) throws Exception{
        ModelUsuario = usuarioDao.getUsuario(idUsuario);
        //Usuario usuario = usuarioDao.getUsuario(idUsuario);
        this.pessoaSelecionada = ModelUsuario.getPessoa();
        for(UsuarioObserver view : usuarioView){
            view.retornaUsuario(ModelUsuario);
        }
    }
    
    public void modificaUsuario(Usuario usuarioMod) throws Exception{
        usuarioMod.setPessoa(pessoaSelecionada);
        usuarioMod.setIdUsuario(ModelUsuario.getIdUsuario());
        usuarioMod.getPessoa().setId(ModelUsuario.getPessoa().getId());
        usuarioDao.modifyUsuario(usuarioMod);
        preencherTabelaUsuario();
        for(UsuarioObserver view : usuarioView){
            view.exibirMensagem("Usuário alterado com sucesso !");
        }
    }
    
    public void excluirUsuario(Long idUsuario) throws Exception{
        Usuario usuario = usuarioDao.getUsuario(idUsuario);
        usuarioDao.deleteUsuario(usuario);
        preencherTabelaUsuario();
        for(UsuarioObserver view : usuarioView){
            view.exibirMensagem("Usuario excluído com sucesso !");
        }
    }

    @Override
    public void retornaObjeto(Object obj) {
        if(obj instanceof Pessoa){
            this.pessoaSelecionada = (Pessoa) obj;
            for(UsuarioObserver view : usuarioView){
                view.retornaPessoa(pessoaSelecionada);
            }
        }
    }
}
