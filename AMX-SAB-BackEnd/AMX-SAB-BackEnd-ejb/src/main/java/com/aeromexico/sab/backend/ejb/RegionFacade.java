package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Region;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table region.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class RegionFacade extends AbstractFacade<Region> implements RegionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public RegionFacade() {
		super(Region.class);
	}

	@Override
	public List<Region> findAllLike(Region x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Region x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdRegion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idRegion = :idRegion");
			}
			if(x.getCveRegion() != null){
			    paramAsigned++;
			    sbq.append(" and x.cveRegion = :cveRegion");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Region> nq = em.createQuery(sbq.toString(), Region.class);
		
		if(paramAsigned>0){
			if(x.getIdRegion() != null){
			    nq.setParameter("idRegion",x.getIdRegion());
			}
			if(x.getCveRegion() != null){
			    nq.setParameter("cveRegion",x.getCveRegion());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Region> findAll() {
		TypedQuery<Region> nq = em.createNamedQuery("Region.findAll", Region.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Region.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
