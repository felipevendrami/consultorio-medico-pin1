/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author felip
 */
public class UsuarioDao extends AcessoBD {

    public void addUsuario(Usuario usuario) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Ocorreu algum erro durante o cadastro do usuário.");
        }
    }

    public List getTodosUsuarios() throws Exception {
        try {
            Query query = entityManager.createQuery("select u from Usuario u");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca de usuários.");
        }
    }

    public Usuario getUsuario(Long idUsuario) throws Exception {
        try {
            return entityManager.find(Usuario.class, idUsuario);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca da usuário.");
        }
    }
    
    public void modifyUsuario(Usuario usuarioMod) throws Exception{
        try {
            
            Usuario Usuario = getUsuario(usuarioMod.getIdUsuario());
            Usuario = usuarioMod;
            entityManager.getTransaction().begin();
            entityManager.merge(Usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema na alteração da usuário.");
        }
    }

    public void deleteUsuario(Usuario usuario) throws Exception{
        try {            
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Ocorre um problema durante a exclusão do usuário.");
        }
    }
    
}
