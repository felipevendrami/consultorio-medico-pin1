/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author felip
 */
public class AcessoBD {
    
    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("consulta-medico-jpa-pu");
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();
    
}
