package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Ciudad;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table ciudad.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> implements CiudadFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CiudadFacade() {
		super(Ciudad.class);
	}

	@Override
	public List<Ciudad> findAllLike(Ciudad x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Ciudad x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdCiudad() != null){
			    paramAsigned++;
			    sbq.append(" and x.idCiudad = :idCiudad");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getPais() != null){
			    paramAsigned++;
			    sbq.append(" and x.pais = :pais");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Ciudad> nq = em.createQuery(sbq.toString(), Ciudad.class);
		
		if(paramAsigned>0){
			if(x.getIdCiudad() != null){
			    nq.setParameter("idCiudad",x.getIdCiudad());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getPais() != null){
			    nq.setParameter("pais",x.getPais());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Ciudad> findAll() {
		TypedQuery<Ciudad> nq = em.createNamedQuery("Ciudad.findAll", Ciudad.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Ciudad.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
