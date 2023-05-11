package com.project.davidphotostock.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionUtil {
    
    private static EntityManager em = null;
    private static EntityManagerFactory emf = null;
    
    public static EntityManager getInstance(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("davidphotostock-pu");
        }
        if(em == null){
            em = emf.createEntityManager();
        }        
        return em;
    }
    
    
    
}
