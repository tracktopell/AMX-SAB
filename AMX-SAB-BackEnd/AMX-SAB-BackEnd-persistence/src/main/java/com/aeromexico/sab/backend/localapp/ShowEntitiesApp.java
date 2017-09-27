package com.tracktopell.openlegacy.fullstackexam.localapp;

import com.tracktopell.openlegacy.fullstackexam.dto.CustomerDTO;
import com.tracktopell.openlegacy.fullstackexam.persistence.DAOFactory;
import com.tracktopell.openlegacy.fullstackexam.persistence.DAOFactoryBuilder;
import com.tracktopell.openlegacy.fullstackexam.persistence.EntityDAO;
import com.tracktopell.openlegacy.fullstackexam.persistence.jpa.entity.Customer;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alfredo
 */
public class ShowEntitiesApp {
	private static Logger logger = LoggerFactory.getLogger(ShowEntitiesApp.class.getName());
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager        entityManager;	
	
	public static void main(String[] args) {
		
		DAOFactoryBuilder.installDAOFactory("com.tracktopell.openlegacy.fullstackexam.persistence.jpa.JPADAOFactory");
		
		DAOFactory registeredDAOFactory = DAOFactoryBuilder.getRegisteredDAOFactory();
		
		logger.info("registeredDAOFactory="+registeredDAOFactory);
		
		logger.info("loading persistence.xml ");
		entityManagerFactory = Persistence.createEntityManagerFactory("OL_EXAM_PU");
		
		logger.info("ok loaded persistence.xml ");
		logger.info("entityManagerFactory = "+entityManagerFactory);
		
		EntityDAO<CustomerDTO> customerDAO = registeredDAOFactory.getCustomerDAO();
		logger.info("customerDAO= "+customerDAO);
		
		customerDAO.setDataSource(entityManagerFactory);
		
		List<CustomerDTO> customerList = null;
		
		customerList = customerDAO.findAll();
		for(CustomerDTO customer: customerList){
			logger.info("\tDTO:"+customer);
		}
		
		/*
		logger.info("loading persistence.xml ");
		entityManagerFactory = Persistence.createEntityManagerFactory("OL_EXAM_PU");
		logger.info("ok loaded persistence.xml ");
		logger.info("entityManager = "+entityManagerFactory);
		entityManager = entityManagerFactory.createEntityManager();
		logger.info("entityManager = "+entityManager);

		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		logger.info("JPA Entities: ");		
		for(EntityType et:entities){
			logger.info("\tEntity:"+et.getName());
		}
		logger.info("Total size:"+entities.size());
		
		List<Customer> customerList = cc.findCustomerEntities();
		logger.info("====================================>>>");
		for(Customer c: customerList){
			logger.info("->Customer:"+c);
		}
		*/
		
	}	
}
