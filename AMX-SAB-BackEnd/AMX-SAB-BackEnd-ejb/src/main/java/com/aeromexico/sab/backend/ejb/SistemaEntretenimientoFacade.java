package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.SistemaEntretenimiento;
import com.aeromexico.sab.backend.remote.SistemaEntretenimientoFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table sistema_entretenimiento.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Stateless
public class SistemaEntretenimientoFacade extends AbstractFacade<SistemaEntretenimiento> implements SistemaEntretenimientoFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public SistemaEntretenimientoFacade() {
		super(SistemaEntretenimiento.class);
	}

	@Override
	public List<SistemaEntretenimiento> findAllLike(SistemaEntretenimiento x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM SistemaEntretenimiento x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdSistemaEntretenimiento() != null){
			    paramAsigned++;
			    sbq.append(" and x.idSistemaEntretenimiento = :idSistemaEntretenimiento");
			}
			if(x.getTipo() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipo = :tipo");
			}
			if(x.getVersion() != null){
			    paramAsigned++;
			    sbq.append(" and x.version = :version");
			}
			if(x.getDescripcion() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcion = :descripcion");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<SistemaEntretenimiento> nq = em.createQuery(sbq.toString(), SistemaEntretenimiento.class);
		
		if(paramAsigned>0){
			if(x.getIdSistemaEntretenimiento() != null){
			    nq.setParameter("idSistemaEntretenimiento",x.getIdSistemaEntretenimiento());
			}
			if(x.getTipo() != null){
			    nq.setParameter("tipo",x.getTipo());
			}
			if(x.getVersion() != null){
			    nq.setParameter("version",x.getVersion());
			}
			if(x.getDescripcion() != null){
			    nq.setParameter("descripcion",x.getDescripcion());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<SistemaEntretenimiento> findAll() {
		TypedQuery<SistemaEntretenimiento> nq = em.createNamedQuery("SistemaEntretenimiento.findAll", SistemaEntretenimiento.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("SistemaEntretenimiento.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
