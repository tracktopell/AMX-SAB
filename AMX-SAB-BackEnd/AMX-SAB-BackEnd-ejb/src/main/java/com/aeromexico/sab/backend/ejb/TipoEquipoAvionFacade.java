package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.TipoEquipoAvion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table tipo_equipo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class TipoEquipoAvionFacade extends AbstractFacade<TipoEquipoAvion> implements TipoEquipoAvionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public TipoEquipoAvionFacade() {
		super(TipoEquipoAvion.class);
	}

	@Override
	public List<TipoEquipoAvion> findAllLike(TipoEquipoAvion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM TipoEquipoAvion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdTipoEquipoAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idTipoEquipoAvion = :idTipoEquipoAvion");
			}
			if(x.getModeloAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.modeloAvion = :modeloAvion");
			}
			if(x.getTotalAviones() != null){
			    paramAsigned++;
			    sbq.append(" and x.totalAviones = :totalAviones");
			}
			if(x.getTipoEquipo() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoEquipo = :tipoEquipo");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<TipoEquipoAvion> nq = em.createQuery(sbq.toString(), TipoEquipoAvion.class);
		
		if(paramAsigned>0){
			if(x.getIdTipoEquipoAvion() != null){
			    nq.setParameter("idTipoEquipoAvion",x.getIdTipoEquipoAvion());
			}
			if(x.getModeloAvion() != null){
			    nq.setParameter("modeloAvion",x.getModeloAvion());
			}
			if(x.getTotalAviones() != null){
			    nq.setParameter("totalAviones",x.getTotalAviones());
			}
			if(x.getTipoEquipo() != null){
			    nq.setParameter("tipoEquipo",x.getTipoEquipo());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<TipoEquipoAvion> findAll() {
		TypedQuery<TipoEquipoAvion> nq = em.createNamedQuery("TipoEquipoAvion.findAll", TipoEquipoAvion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("TipoEquipoAvion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
