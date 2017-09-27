package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.TipoProveedor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table tipo_proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class TipoProveedorFacade extends AbstractFacade<TipoProveedor> implements TipoProveedorFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public TipoProveedorFacade() {
		super(TipoProveedor.class);
	}

	@Override
	public List<TipoProveedor> findAllLike(TipoProveedor x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM TipoProveedor x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdTipoProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.idTipoProveedor = :idTipoProveedor");
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
		
		TypedQuery<TipoProveedor> nq = em.createQuery(sbq.toString(), TipoProveedor.class);
		
		if(paramAsigned>0){
			if(x.getIdTipoProveedor() != null){
			    nq.setParameter("idTipoProveedor",x.getIdTipoProveedor());
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
	public List<TipoProveedor> findAll() {
		TypedQuery<TipoProveedor> nq = em.createNamedQuery("TipoProveedor.findAll", TipoProveedor.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("TipoProveedor.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
