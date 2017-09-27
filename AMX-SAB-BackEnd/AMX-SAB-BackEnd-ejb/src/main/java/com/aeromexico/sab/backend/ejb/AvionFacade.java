package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Avion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class AvionFacade extends AbstractFacade<Avion> implements AvionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AvionFacade() {
		super(Avion.class);
	}

	@Override
	public List<Avion> findAllLike(Avion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Avion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idAvion = :idAvion");
			}
			if(x.getTipoEquipoAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoEquipoAvion = :tipoEquipoAvion");
			}
			if(x.getMatricula() != null){
			    paramAsigned++;
			    sbq.append(" and x.matricula = :matricula");
			}
			if(x.getMatriculaCorta() != null){
			    paramAsigned++;
			    sbq.append(" and x.matriculaCorta = :matriculaCorta");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Avion> nq = em.createQuery(sbq.toString(), Avion.class);
		
		if(paramAsigned>0){
			if(x.getIdAvion() != null){
			    nq.setParameter("idAvion",x.getIdAvion());
			}
			if(x.getTipoEquipoAvion() != null){
			    nq.setParameter("tipoEquipoAvion",x.getTipoEquipoAvion());
			}
			if(x.getMatricula() != null){
			    nq.setParameter("matricula",x.getMatricula());
			}
			if(x.getMatriculaCorta() != null){
			    nq.setParameter("matriculaCorta",x.getMatriculaCorta());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Avion> findAll() {
		TypedQuery<Avion> nq = em.createNamedQuery("Avion.findAll", Avion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Avion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
