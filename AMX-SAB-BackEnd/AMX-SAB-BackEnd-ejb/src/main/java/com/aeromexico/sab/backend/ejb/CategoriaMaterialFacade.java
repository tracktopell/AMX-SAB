package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.CategoriaMaterial;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table categoria_material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class CategoriaMaterialFacade extends AbstractFacade<CategoriaMaterial> implements CategoriaMaterialFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CategoriaMaterialFacade() {
		super(CategoriaMaterial.class);
	}

	@Override
	public List<CategoriaMaterial> findAllLike(CategoriaMaterial x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM CategoriaMaterial x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdCategoriaMaterial() != null){
			    paramAsigned++;
			    sbq.append(" and x.idCategoriaMaterial = :idCategoriaMaterial");
			}
			if(x.getNombreEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEs = :nombreEs");
			}
			if(x.getNombreEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEn = :nombreEn");
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
		
		TypedQuery<CategoriaMaterial> nq = em.createQuery(sbq.toString(), CategoriaMaterial.class);
		
		if(paramAsigned>0){
			if(x.getIdCategoriaMaterial() != null){
			    nq.setParameter("idCategoriaMaterial",x.getIdCategoriaMaterial());
			}
			if(x.getNombreEs() != null){
			    nq.setParameter("nombreEs",x.getNombreEs());
			}
			if(x.getNombreEn() != null){
			    nq.setParameter("nombreEn",x.getNombreEn());
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
	public List<CategoriaMaterial> findAll() {
		TypedQuery<CategoriaMaterial> nq = em.createNamedQuery("CategoriaMaterial.findAll", CategoriaMaterial.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("CategoriaMaterial.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
