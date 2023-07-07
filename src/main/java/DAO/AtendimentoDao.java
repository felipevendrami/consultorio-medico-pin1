/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Atendimento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author felip
 */
public class AtendimentoDao extends AcessoBD {

    public void addAtendimento(Atendimento atendimento) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(atendimento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Ocorreu algum erro durante o cadastro do médico.");
        }
    }

    public List getTodosAtendimentos() throws Exception {
        try {
            Query query = entityManager.createQuery("select m from Atendimento m");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca de médicos.");
        }
    }

    public Atendimento getAtendimento(Long idAtendimento) throws Exception {
        try {
            return entityManager.find(Atendimento.class, idAtendimento);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca do médico.");
        }
    }
    
    public void modifyAtendimento(Atendimento atendimentoMod) throws Exception{
        try {
            
            Atendimento atendimento = getAtendimento(atendimentoMod.getIdAtendimento());
            atendimento = atendimentoMod;
            entityManager.getTransaction().begin();
            entityManager.merge(atendimento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema na alteração da médico.");
        }
    }

    public void deleteAtendimento(Atendimento atendimento) throws Exception{
        try {            
            entityManager.getTransaction().begin();
            entityManager.remove(atendimento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Ocorre um problema durante a exclusão da médico.");
        }
    }
    
}
