package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.AvionAudifono;
import com.aeromexico.sab.backend.remote.AvionAudifonoFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table avion_audifono.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class AvionAudifonoFacade extends AbstractFacade<AvionAudifono> implements AvionAudifonoFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AvionAudifonoFacade() {
		super(AvionAudifono.class);
	}

	@Override
	public List<AvionAudifono> findAllLike(AvionAudifono x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM AvionAudifono x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdAvionAudifono() != null){
			    paramAsigned++;
			    sbq.append(" and x.idAvionAudifono = :idAvionAudifono");
			}
			if(x.getAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.avion = :avion");
			}
			if(x.getClase() != null){
			    paramAsigned++;
			    sbq.append(" and x.clase = :clase");
			}
			if(x.getTipoAudifono() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoAudifono = :tipoAudifono");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<AvionAudifono> nq = em.createQuery(sbq.toString(), AvionAudifono.class);
		
		if(paramAsigned>0){
			if(x.getIdAvionAudifono() != null){
			    nq.setParameter("idAvionAudifono",x.getIdAvionAudifono());
			}
			if(x.getAvion() != null){
			    nq.setParameter("avion",x.getAvion());
			}
			if(x.getClase() != null){
			    nq.setParameter("clase",x.getClase());
			}
			if(x.getTipoAudifono() != null){
			    nq.setParameter("tipoAudifono",x.getTipoAudifono());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<AvionAudifono> findAll() {
		TypedQuery<AvionAudifono> nq = em.createNamedQuery("AvionAudifono.findAll", AvionAudifono.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("AvionAudifono.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
