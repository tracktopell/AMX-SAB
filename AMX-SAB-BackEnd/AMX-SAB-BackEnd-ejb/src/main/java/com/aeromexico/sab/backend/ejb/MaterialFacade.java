package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Material;
import com.aeromexico.sab.backend.remote.MaterialFacadeRemote;

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
 * @version 1.13.1
 * @date 2017/09/30 07:39
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
			if(x.getCategoria() != null){
			    paramAsigned++;
			    sbq.append(" and x.categoria = :categoria");
			}
			if(x.getDescripcionEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcionEs = :descripcionEs");
			}
			if(x.getDescripcionEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcionEn = :descripcionEn");
			}
			if(x.getTipoAbastecimiento() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoAbastecimiento = :tipoAbastecimiento");
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
			if(x.getCategoria() != null){
			    nq.setParameter("categoria",x.getCategoria());
			}
			if(x.getDescripcionEs() != null){
			    nq.setParameter("descripcionEs",x.getDescripcionEs());
			}
			if(x.getDescripcionEn() != null){
			    nq.setParameter("descripcionEn",x.getDescripcionEn());
			}
			if(x.getTipoAbastecimiento() != null){
			    nq.setParameter("tipoAbastecimiento",x.getTipoAbastecimiento());
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
