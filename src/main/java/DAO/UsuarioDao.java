/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
    
    public boolean authenticateMedico(String email, String senha) throws Exception{
        try {
            String sql = String.format("SELECT p.id_pessoa FROM Usuario u JOIN Pessoa p ON u.id_pessoa = p.id_pessoa JOIN Medico m ON p.id_pessoa = m.id_pessoa WHERE p.email = '%s' AND u.senha = '%s'", email, senha);
            Query query = entityManager.createNativeQuery(sql);
            //Query query = entityManager.createQuery("SELECT u FROM Usuario u JOIN Pessoa p ON u.id_pessoa = p.id_pessoa JOIN Medico m ON p.id_pessoa = m.id_pessoa WHERE p.email = :email AND u.senha = :senha");
            //query.setParameter("email", email);
            //query.setParameter("senha", senha); 
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean authenticateUsuario(String email, String senha) {
        try {
            String sql = String.format("SELECT * FROM Usuario u JOIN Pessoa p ON u.id_pessoa = p.id_pessoa WHERE p.email = '%s' AND u.senha = '%s'", email, senha);
            Query query = entityManager.createNativeQuery(sql);
            //query.setParameter("email", email);
            //query.setParameter("senha", senha); 
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
