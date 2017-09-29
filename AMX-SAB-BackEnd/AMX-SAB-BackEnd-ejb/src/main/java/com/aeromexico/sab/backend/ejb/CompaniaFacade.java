package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Compania;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table compania.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */
@Stateless
public class CompaniaFacade extends AbstractFacade<Compania> implements CompaniaFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CompaniaFacade() {
		super(Compania.class);
	}

	@Override
	public List<Compania> findAllLike(Compania x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Compania x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdCompania() != null){
			    paramAsigned++;
			    sbq.append(" and x.idCompania = :idCompania");
			}
			if(x.getCveCompania() != null){
			    paramAsigned++;
			    sbq.append(" and x.cveCompania = :cveCompania");
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
		
		TypedQuery<Compania> nq = em.createQuery(sbq.toString(), Compania.class);
		
		if(paramAsigned>0){
			if(x.getIdCompania() != null){
			    nq.setParameter("idCompania",x.getIdCompania());
			}
			if(x.getCveCompania() != null){
			    nq.setParameter("cveCompania",x.getCveCompania());
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
	public List<Compania> findAll() {
		TypedQuery<Compania> nq = em.createNamedQuery("Compania.findAll", Compania.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Compania.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
