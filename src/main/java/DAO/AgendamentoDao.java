/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Agendamento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author felip
 */
public class AgendamentoDao extends AcessoBD{

    public List getTodosAgendamentos() throws Exception {
        try{
            Query query = entityManager.createQuery("select a from Agendamento a");
            return query.getResultList();
        } catch (Exception e){
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca de agendamentos");
        }
    }

    public void addAgendamento(Agendamento agendamento) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(agendamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocoreu um problema ao realizar o agendamento.");
        }
    }

    public Agendamento getAgendamento(Long idAgendamento) throws Exception {
        try {
            return entityManager.find(Agendamento.class, idAgendamento);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca do agendamento");
        }
    }

    public void modifyAgendamento(Agendamento agendamentoMod) throws Exception {
        try {
            Agendamento agendamento = getAgendamento(agendamentoMod.getIdAgendamento());
            agendamento = agendamentoMod;
            entityManager.getTransaction().begin();
            entityManager.merge(agendamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema na alteração do agendamento.");
        }
    }

    public void deleteAgendamento(Agendamento agendamento) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(agendamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Ocorreu um problema durante a exclusão do agendamento");
        }
    }

}
