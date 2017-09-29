package com.aeromexico.sab.backend.localapp;

import com.aeromexico.sab.backend.entity.Perfil;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.aeromexico.sab.backend.localapp.ShowEntitiesApp
 * @author alfredo
 */
public class ShowEntitiesApp {
	private static Logger logger = LoggerFactory.getLogger(ShowEntitiesApp.class.getName());
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager        entityManager;

	static { //runs when the main class is loaded.
		System.setProperty("derby.stream.error.method","com.gonet.papadoc.persistence.test.DerbySlf4jBridge.bridge");
		System.setProperty("org.jboss.logging.provider", "slf4j");		
		System.setProperty("derby.system.home", System.getProperty("user.home")+"/DERBY_DATABASES");
	}		
	
	public static void main(String[] args) {
		installCreateDB();
	}
	
	public static void installCreateDB() {
		
		logger.info("loading persistence.xml ");
		entityManagerFactory = Persistence.createEntityManagerFactory("AMX_SAB_PU_MEMORY");
		//entityManagerFactory = Persistence.createEntityManagerFactory("AMX_SAB_PU");
		logger.info("ok loaded persistence.xml ");
		logger.info("entityManager = "+entityManagerFactory);
		entityManager = entityManagerFactory.createEntityManager();
		logger.info("entityManager = "+entityManager);
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		logger.info("====================================>>>");
		
		logger.info("JPA Entities: ");		
		for(EntityType et:entities){
			logger.info("\tEntity:"+et.getName());
		}
		
		logger.info("Total size:"+entities.size());
		
		entityManager.getTransaction().begin();
		logger.info("---------------------------[TB]>>>");
		List<Perfil> perfilList1= entityManager.createNamedQuery("Perfil.findAll").getResultList();
		logger.info("Perfil before:-->");
		for(Perfil p: perfilList1){
			logger.info("\t->Perfil:"+p);
		}
		logger.info("Perfil before:<--");
		
		Perfil perfilX=new Perfil();
		perfilX.setEstatus((short)1);
		long t1=System.currentTimeMillis();
		perfilX.setNombre("PERF_"+ ((int)(t1%1000)) );
		
		
		entityManager.persist(perfilX);
		
		
		
		List<Perfil> perfilList2= entityManager.createNamedQuery("Perfil.findAll").getResultList();
		logger.info("Perfil after:-->");
		for(Perfil p: perfilList2){
			logger.info("\t->Perfil:"+p);
		}
		logger.info("Perfil after:<--");
		
		entityManager.getTransaction().commit();
		logger.info("---------------------------[TC]<<<");
		logger.info("<<<====================================");
		if(entityManager != null){
			entityManager.close();
			logger.info("entityManager closed");
		}
		if(entityManagerFactory !=null){
			entityManagerFactory.close();
			logger.info("entityManagerFatory closed");
		}
	}
}
