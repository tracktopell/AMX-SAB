package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Parametros;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table parametros.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class ParametrosFacade extends AbstractFacade<Parametros> implements ParametrosFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ParametrosFacade() {
		super(Parametros.class);
	}

	@Override
	public List<Parametros> findAllLike(Parametros x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Parametros x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdParametro() != null){
			    paramAsigned++;
			    sbq.append(" and x.idParametro = :idParametro");
			}
			if(x.getClave() != null){
			    paramAsigned++;
			    sbq.append(" and x.clave = :clave");
			}
			if(x.getValor() != 0){
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
		
		TypedQuery<Parametros> nq = em.createQuery(sbq.toString(), Parametros.class);
		
		if(paramAsigned>0){
			if(x.getIdParametro() != null){
			    nq.setParameter("idParametro",x.getIdParametro());
			}
			if(x.getClave() != null){
			    nq.setParameter("clave",x.getClave());
			}
			if(x.getValor() != (0) ){
			    nq.setParameter("valor",x.getValor());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Parametros> findAll() {
		TypedQuery<Parametros> nq = em.createNamedQuery("Parametros.findAll", Parametros.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Parametros.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
