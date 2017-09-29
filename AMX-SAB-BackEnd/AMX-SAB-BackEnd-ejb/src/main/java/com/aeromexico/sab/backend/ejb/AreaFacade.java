package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Area;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table area.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */
@Stateless
public class AreaFacade extends AbstractFacade<Area> implements AreaFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AreaFacade() {
		super(Area.class);
	}

	@Override
	public List<Area> findAllLike(Area x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Area x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdArea() != null){
			    paramAsigned++;
			    sbq.append(" and x.idArea = :idArea");
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
		
		TypedQuery<Area> nq = em.createQuery(sbq.toString(), Area.class);
		
		if(paramAsigned>0){
			if(x.getIdArea() != null){
			    nq.setParameter("idArea",x.getIdArea());
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
	public List<Area> findAll() {
		TypedQuery<Area> nq = em.createNamedQuery("Area.findAll", Area.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Area.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
