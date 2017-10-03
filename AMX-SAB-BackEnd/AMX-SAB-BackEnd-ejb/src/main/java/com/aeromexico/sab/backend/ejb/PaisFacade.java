package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Pais;
import com.aeromexico.sab.backend.remote.PaisFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table pais.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PaisFacade() {
		super(Pais.class);
	}

	@Override
	public List<Pais> findAllLike(Pais x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Pais x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdPais() != null){
			    paramAsigned++;
			    sbq.append(" and x.idPais = :idPais");
			}
			if(x.getCvePais() != null){
			    paramAsigned++;
			    sbq.append(" and x.cvePais = :cvePais");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getRegion() != null){
			    paramAsigned++;
			    sbq.append(" and x.region = :region");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Pais> nq = em.createQuery(sbq.toString(), Pais.class);
		
		if(paramAsigned>0){
			if(x.getIdPais() != null){
			    nq.setParameter("idPais",x.getIdPais());
			}
			if(x.getCvePais() != null){
			    nq.setParameter("cvePais",x.getCvePais());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getRegion() != null){
			    nq.setParameter("region",x.getRegion());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Pais> findAll() {
		TypedQuery<Pais> nq = em.createNamedQuery("Pais.findAll", Pais.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Pais.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
