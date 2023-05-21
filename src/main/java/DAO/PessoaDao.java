/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Pessoa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author felip
 */
public class PessoaDao extends AcessoBD {

    public void addPessoa(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa.getEndereco());
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List getTodasPessoas() throws Exception {
        try {
            Query query = entityManager.createQuery("select p from Pessoa p");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca de pessoas.");
        }
    }

    public Pessoa getPessoa(Long idPessoa) throws Exception {
        try {
            return entityManager.find(Pessoa.class, idPessoa);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema durante a busca da pessoa.");
        }
    }
    
    public void modifyPessoa(Pessoa pessoaMod) throws Exception{
        try {
            
            Pessoa pessoa = getPessoa(pessoaMod.getId());
            pessoa = pessoaMod;
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new Exception("Ocorreu um problema na alteração da pessoa.");
        } finally {
            entityManager.close();
        }
    }

}
