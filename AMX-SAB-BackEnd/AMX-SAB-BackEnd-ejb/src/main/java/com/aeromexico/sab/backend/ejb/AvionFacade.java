package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Avion;
import com.aeromexico.sab.backend.remote.AvionFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
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
			if(x.getIdConectividad() != null){
			    paramAsigned++;
			    sbq.append(" and x.idConectividad = :idConectividad");
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
			if(x.getIdConectividad() != null){
			    nq.setParameter("idConectividad",x.getIdConectividad());
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
