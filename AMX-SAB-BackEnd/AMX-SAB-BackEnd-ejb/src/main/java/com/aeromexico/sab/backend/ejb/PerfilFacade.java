package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Perfil;
import com.aeromexico.sab.backend.remote.PerfilFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class PerfilFacade extends AbstractFacade<Perfil> implements PerfilFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PerfilFacade() {
		super(Perfil.class);
	}

	@Override
	public List<Perfil> findAllLike(Perfil x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Perfil x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getPerfil() != null){
			    paramAsigned++;
			    sbq.append(" and x.perfil = :perfil");
			}
			if(x.getDescripcion() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcion = :descripcion");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Perfil> nq = em.createQuery(sbq.toString(), Perfil.class);
		
		if(paramAsigned>0){
			if(x.getPerfil() != null){
			    nq.setParameter("perfil",x.getPerfil());
			}
			if(x.getDescripcion() != null){
			    nq.setParameter("descripcion",x.getDescripcion());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Perfil> findAll() {
		TypedQuery<Perfil> nq = em.createNamedQuery("Perfil.findAll", Perfil.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Perfil.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
