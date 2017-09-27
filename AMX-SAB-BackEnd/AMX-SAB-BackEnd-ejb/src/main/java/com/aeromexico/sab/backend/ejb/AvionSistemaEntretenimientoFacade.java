package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.AvionSistemaEntretenimiento;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table avion_sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class AvionSistemaEntretenimientoFacade extends AbstractFacade<AvionSistemaEntretenimiento> implements AvionSistemaEntretenimientoFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AvionSistemaEntretenimientoFacade() {
		super(AvionSistemaEntretenimiento.class);
	}

	@Override
	public List<AvionSistemaEntretenimiento> findAllLike(AvionSistemaEntretenimiento x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM AvionSistemaEntretenimiento x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdAvionSistemaEntretenimiento() != null){
			    paramAsigned++;
			    sbq.append(" and x.idAvionSistemaEntretenimiento = :idAvionSistemaEntretenimiento");
			}
			if(x.getAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.avion = :avion");
			}
			if(x.getSistemaEntretenimiento() != null){
			    paramAsigned++;
			    sbq.append(" and x.sistemaEntretenimiento = :sistemaEntretenimiento");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<AvionSistemaEntretenimiento> nq = em.createQuery(sbq.toString(), AvionSistemaEntretenimiento.class);
		
		if(paramAsigned>0){
			if(x.getIdAvionSistemaEntretenimiento() != null){
			    nq.setParameter("idAvionSistemaEntretenimiento",x.getIdAvionSistemaEntretenimiento());
			}
			if(x.getAvion() != null){
			    nq.setParameter("avion",x.getAvion());
			}
			if(x.getSistemaEntretenimiento() != null){
			    nq.setParameter("sistemaEntretenimiento",x.getSistemaEntretenimiento());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<AvionSistemaEntretenimiento> findAll() {
		TypedQuery<AvionSistemaEntretenimiento> nq = em.createNamedQuery("AvionSistemaEntretenimiento.findAll", AvionSistemaEntretenimiento.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("AvionSistemaEntretenimiento.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
