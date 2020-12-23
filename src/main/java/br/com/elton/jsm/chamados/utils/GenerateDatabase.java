package br.com.elton.jsm.chamados.utils;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateDatabase {

	public static void main(String[] args) {
		Properties cfg = new Properties();
		cfg.setProperty("hibernate.hdm2dll.auto", "update");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default", cfg);
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
	
	/**
		iniciar o servidor hsqldb ..:  
		C:\ambiente\projeto\hsqldb> java -cp hsqldb.jar org.hsqldb.Server
	
	
		C:\ambiente\projeto\hsqldb> java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
		
	*/
}
