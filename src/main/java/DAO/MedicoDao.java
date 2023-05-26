/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Medico;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author felip
 */
public class MedicoDao extends AcessoBD {

    public void addMedico(Medico medico) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(medico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Ocorreu algum erro durante o cadastro do médico.");
        }
    }

    public List getTodosMedicos() throws Exception {
        try {
            Query query = entityManager.createQuery("select m from Medico m");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca de médicos.");
        }
    }

    public Medico getMedico(Long idMedico) throws Exception {
        try {
            return entityManager.find(Medico.class, idMedico);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca do médico.");
        }
    }
    
    public void modifyMedico(Medico medicoMod) throws Exception{
        try {
            
            Medico medico = getMedico(medicoMod.getIdMedico());
            medico = medicoMod;
            entityManager.getTransaction().begin();
            entityManager.merge(medico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema na alteração da médico.");
        }
    }

    public void deleteMedico(Medico medico) throws Exception{
        try {            
            entityManager.getTransaction().begin();
            entityManager.remove(medico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Ocorre um problema durante a exclusão da médico.");
        }
    }
    
}
