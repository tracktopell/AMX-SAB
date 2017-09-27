package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Material;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table material.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class MaterialFacade extends AbstractFacade<Material> implements MaterialFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MaterialFacade() {
		super(Material.class);
	}

	@Override
	public List<Material> findAllLike(Material x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Material x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getNumeroParte() != null){
			    paramAsigned++;
			    sbq.append(" and x.numeroParte = :numeroParte");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			if(x.getDescripcionEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcionEs = :descripcionEs");
			}
			if(x.getDescripcionEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcionEn = :descripcionEn");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			if(x.getUrlMultimedia() != null){
			    paramAsigned++;
			    sbq.append(" and x.urlMultimedia = :urlMultimedia");
			}
			if(x.getCategoriaMaterial() != null){
			    paramAsigned++;
			    sbq.append(" and x.categoriaMaterial = :categoriaMaterial");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Material> nq = em.createQuery(sbq.toString(), Material.class);
		
		if(paramAsigned>0){
			if(x.getNumeroParte() != null){
			    nq.setParameter("numeroParte",x.getNumeroParte());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			if(x.getDescripcionEs() != null){
			    nq.setParameter("descripcionEs",x.getDescripcionEs());
			}
			if(x.getDescripcionEn() != null){
			    nq.setParameter("descripcionEn",x.getDescripcionEn());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			if(x.getUrlMultimedia() != null){
			    nq.setParameter("urlMultimedia",x.getUrlMultimedia());
			}
			if(x.getCategoriaMaterial() != null){
			    nq.setParameter("categoriaMaterial",x.getCategoriaMaterial());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Material> findAll() {
		TypedQuery<Material> nq = em.createNamedQuery("Material.findAll", Material.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Material.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
