package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.EquipamientoComisariato;
import com.aeromexico.sab.backend.remote.EquipamientoComisariatoFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table equipamiento_comisariato.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Stateless
public class EquipamientoComisariatoFacade extends AbstractFacade<EquipamientoComisariato> implements EquipamientoComisariatoFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EquipamientoComisariatoFacade() {
		super(EquipamientoComisariato.class);
	}

	@Override
	public List<EquipamientoComisariato> findAllLike(EquipamientoComisariato x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM EquipamientoComisariato x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdEquipamientoComisariato() != null){
			    paramAsigned++;
			    sbq.append(" and x.idEquipamientoComisariato = :idEquipamientoComisariato");
			}
			if(x.getAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.avion = :avion");
			}
			if(x.getNombreEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEs = :nombreEs");
			}
			if(x.getNombreEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEn = :nombreEn");
			}
			if(x.getCantidad()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.cantidad = :cantidad");
			}
			if(x.getPeso()  != 0.0){
			    paramAsigned++;
			    sbq.append(" and x.peso = :peso");
			}
			if(x.getObservaciones() != null){
			    paramAsigned++;
			    sbq.append(" and x.observaciones = :observaciones");
			}
			if(x.getMaterial() != null){
			    paramAsigned++;
			    sbq.append(" and x.material = :material");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<EquipamientoComisariato> nq = em.createQuery(sbq.toString(), EquipamientoComisariato.class);
		
		if(paramAsigned>0){
			if(x.getIdEquipamientoComisariato() != null){
			    nq.setParameter("idEquipamientoComisariato",x.getIdEquipamientoComisariato());
			}
			if(x.getAvion() != null){
			    nq.setParameter("avion",x.getAvion());
			}
			if(x.getNombreEs() != null){
			    nq.setParameter("nombreEs",x.getNombreEs());
			}
			if(x.getNombreEn() != null){
			    nq.setParameter("nombreEn",x.getNombreEn());
			}
			if(x.getCantidad()  != 0){
			    nq.setParameter("cantidad",x.getCantidad());
			}
			if(x.getPeso()  != 0.0){
			    nq.setParameter("peso",x.getPeso());
			}
			if(x.getObservaciones() != null){
			    nq.setParameter("observaciones",x.getObservaciones());
			}
			if(x.getMaterial() != null){
			    nq.setParameter("material",x.getMaterial());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<EquipamientoComisariato> findAll() {
		TypedQuery<EquipamientoComisariato> nq = em.createNamedQuery("EquipamientoComisariato.findAll", EquipamientoComisariato.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("EquipamientoComisariato.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
