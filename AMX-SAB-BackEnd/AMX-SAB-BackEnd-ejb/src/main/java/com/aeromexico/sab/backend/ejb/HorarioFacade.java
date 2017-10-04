package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Horario;
import com.aeromexico.sab.backend.remote.HorarioFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table horario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class HorarioFacade extends AbstractFacade<Horario> implements HorarioFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public HorarioFacade() {
		super(Horario.class);
	}

	@Override
	public List<Horario> findAllLike(Horario x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Horario x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdHorario() != null){
			    paramAsigned++;
			    sbq.append(" and x.idHorario = :idHorario");
			}
			if(x.getRegion() != null){
			    paramAsigned++;
			    sbq.append(" and x.region = :region");
			}
			if(x.getHoraInicio() != null){
			    paramAsigned++;
			    sbq.append(" and x.horaInicio = :horaInicio");
			}
			if(x.getHoraFin() != null){
			    paramAsigned++;
			    sbq.append(" and x.horaFin = :horaFin");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Horario> nq = em.createQuery(sbq.toString(), Horario.class);
		
		if(paramAsigned>0){
			if(x.getIdHorario() != null){
			    nq.setParameter("idHorario",x.getIdHorario());
			}
			if(x.getRegion() != null){
			    nq.setParameter("region",x.getRegion());
			}
			if(x.getHoraInicio() != null){
			    nq.setParameter("horaInicio",x.getHoraInicio());
			}
			if(x.getHoraFin() != null){
			    nq.setParameter("horaFin",x.getHoraFin());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Horario> findAll() {
		TypedQuery<Horario> nq = em.createNamedQuery("Horario.findAll", Horario.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Horario.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
