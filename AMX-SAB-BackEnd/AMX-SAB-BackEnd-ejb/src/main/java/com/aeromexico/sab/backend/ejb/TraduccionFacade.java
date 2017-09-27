package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Traduccion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table traduccion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class TraduccionFacade extends AbstractFacade<Traduccion> implements TraduccionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public TraduccionFacade() {
		super(Traduccion.class);
	}

	@Override
	public List<Traduccion> findAllLike(Traduccion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Traduccion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdTraduccion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idTraduccion = :idTraduccion");
			}
			if(x.getNombreEntidad() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEntidad = :nombreEntidad");
			}
			if(x.getIdEntidad() != 0){
			    paramAsigned++;
			    sbq.append(" and x.idEntidad = :idEntidad");
			}
			if(x.getCampo() != null){
			    paramAsigned++;
			    sbq.append(" and x.campo = :campo");
			}
			if(x.getValor() != null){
			    paramAsigned++;
			    sbq.append(" and x.valor = :valor");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Traduccion> nq = em.createQuery(sbq.toString(), Traduccion.class);
		
		if(paramAsigned>0){
			if(x.getIdTraduccion() != null){
			    nq.setParameter("idTraduccion",x.getIdTraduccion());
			}
			if(x.getNombreEntidad() != null){
			    nq.setParameter("nombreEntidad",x.getNombreEntidad());
			}
			if(x.getIdEntidad() != (0) ){
			    nq.setParameter("idEntidad",x.getIdEntidad());
			}
			if(x.getCampo() != null){
			    nq.setParameter("campo",x.getCampo());
			}
			if(x.getValor() != null){
			    nq.setParameter("valor",x.getValor());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Traduccion> findAll() {
		TypedQuery<Traduccion> nq = em.createNamedQuery("Traduccion.findAll", Traduccion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Traduccion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
