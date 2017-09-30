package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Clase;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table clase.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> implements ClaseFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ClaseFacade() {
		super(Clase.class);
	}

	@Override
	public List<Clase> findAllLike(Clase x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Clase x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdClase() != null){
			    paramAsigned++;
			    sbq.append(" and x.idClase = :idClase");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getClave() != null){
			    paramAsigned++;
			    sbq.append(" and x.clave = :clave");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Clase> nq = em.createQuery(sbq.toString(), Clase.class);
		
		if(paramAsigned>0){
			if(x.getIdClase() != null){
			    nq.setParameter("idClase",x.getIdClase());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getClave() != null){
			    nq.setParameter("clave",x.getClave());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Clase> findAll() {
		TypedQuery<Clase> nq = em.createNamedQuery("Clase.findAll", Clase.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Clase.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
