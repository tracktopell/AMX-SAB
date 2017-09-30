package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.RelacionFlota;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table relacion_flota.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class RelacionFlotaFacade extends AbstractFacade<RelacionFlota> implements RelacionFlotaFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public RelacionFlotaFacade() {
		super(RelacionFlota.class);
	}

	@Override
	public List<RelacionFlota> findAllLike(RelacionFlota x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM RelacionFlota x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdRelacionFlota() != null){
			    paramAsigned++;
			    sbq.append(" and x.idRelacionFlota = :idRelacionFlota");
			}
			if(x.getRevision()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.revision = :revision");
			}
			if(x.getFecha() != null){
			    paramAsigned++;
			    sbq.append(" and x.fecha = :fecha");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<RelacionFlota> nq = em.createQuery(sbq.toString(), RelacionFlota.class);
		
		if(paramAsigned>0){
			if(x.getIdRelacionFlota() != null){
			    nq.setParameter("idRelacionFlota",x.getIdRelacionFlota());
			}
			if(x.getRevision()  != 0){
			    nq.setParameter("revision",x.getRevision());
			}
			if(x.getFecha() != null){
			    nq.setParameter("fecha",x.getFecha());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<RelacionFlota> findAll() {
		TypedQuery<RelacionFlota> nq = em.createNamedQuery("RelacionFlota.findAll", RelacionFlota.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("RelacionFlota.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
