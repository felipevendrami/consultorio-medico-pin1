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
    
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;
    
    public AcessoBD(){}
    
    public static void setPersistenseUnitProd(){
        entityManagerFactory = Persistence.createEntityManagerFactory("whitehouse");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public static void setPersistenseUnitTest(){
        entityManagerFactory = Persistence.createEntityManagerFactory("whitehouse-test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
