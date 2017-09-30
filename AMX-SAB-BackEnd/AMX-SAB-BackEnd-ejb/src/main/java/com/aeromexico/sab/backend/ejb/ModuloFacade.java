package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Modulo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table modulo.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class ModuloFacade extends AbstractFacade<Modulo> implements ModuloFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ModuloFacade() {
		super(Modulo.class);
	}

	@Override
	public List<Modulo> findAllLike(Modulo x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Modulo x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdModulo() != null){
			    paramAsigned++;
			    sbq.append(" and x.idModulo = :idModulo");
			}
			if(x.getModuloPadre() != null){
			    paramAsigned++;
			    sbq.append(" and x.moduloPadre = :moduloPadre");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getUri() != null){
			    paramAsigned++;
			    sbq.append(" and x.uri = :uri");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Modulo> nq = em.createQuery(sbq.toString(), Modulo.class);
		
		if(paramAsigned>0){
			if(x.getIdModulo() != null){
			    nq.setParameter("idModulo",x.getIdModulo());
			}
			if(x.getModuloPadre() != null){
			    nq.setParameter("moduloPadre",x.getModuloPadre());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getUri() != null){
			    nq.setParameter("uri",x.getUri());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Modulo> findAll() {
		TypedQuery<Modulo> nq = em.createNamedQuery("Modulo.findAll", Modulo.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Modulo.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
