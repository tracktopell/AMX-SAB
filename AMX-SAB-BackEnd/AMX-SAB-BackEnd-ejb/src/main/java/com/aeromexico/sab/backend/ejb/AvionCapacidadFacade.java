package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.AvionCapacidad;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table avion_capacidad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class AvionCapacidadFacade extends AbstractFacade<AvionCapacidad> implements AvionCapacidadFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AvionCapacidadFacade() {
		super(AvionCapacidad.class);
	}

	@Override
	public List<AvionCapacidad> findAllLike(AvionCapacidad x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM AvionCapacidad x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdAvionCapacidad() != null){
			    paramAsigned++;
			    sbq.append(" and x.idAvionCapacidad = :idAvionCapacidad");
			}
			if(x.getAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.avion = :avion");
			}
			if(x.getClase() != null){
			    paramAsigned++;
			    sbq.append(" and x.clase = :clase");
			}
			if(x.getCapacidad() != 0){
			    paramAsigned++;
			    sbq.append(" and x.capacidad = :capacidad");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<AvionCapacidad> nq = em.createQuery(sbq.toString(), AvionCapacidad.class);
		
		if(paramAsigned>0){
			if(x.getIdAvionCapacidad() != null){
			    nq.setParameter("idAvionCapacidad",x.getIdAvionCapacidad());
			}
			if(x.getAvion() != null){
			    nq.setParameter("avion",x.getAvion());
			}
			if(x.getClase() != null){
			    nq.setParameter("clase",x.getClase());
			}
			if(x.getCapacidad() != (0) ){
			    nq.setParameter("capacidad",x.getCapacidad());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<AvionCapacidad> findAll() {
		TypedQuery<AvionCapacidad> nq = em.createNamedQuery("AvionCapacidad.findAll", AvionCapacidad.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("AvionCapacidad.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
