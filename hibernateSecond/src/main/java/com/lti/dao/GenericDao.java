package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GenericDao {
	
	public Object save(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			EntityTransaction tx= em.getTransaction();
			tx.begin();
			
			Object object= em.merge(obj);
			
			tx.commit();	
			
			return object;
		}
		finally {
			em.close();
			emf.close();	
		}
		
		
	}
	
	public Object fetchByPk(Class clazz, Object pk) {
		EntityManagerFactory emf=null;
		EntityManager em= null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em= emf.createEntityManager();

			Object obj = em.find(clazz, pk);
			return obj;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Object> fetchAll() {
		EntityManagerFactory emf=null;
		EntityManager em= null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em= emf.createEntityManager();
			
			Query q = em.createQuery("select o from Object o");
			List<Object> list = q.getResultList();
			
			return list;
		}
		finally {
			em.close();
			emf.close();
		}
	
	}

}
