package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Proveedor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table proveedor.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> implements ProveedorFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProveedorFacade() {
		super(Proveedor.class);
	}

	@Override
	public List<Proveedor> findAllLike(Proveedor x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Proveedor x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.idProveedor = :idProveedor");
			}
			if(x.getTipoProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoProveedor = :tipoProveedor");
			}
			if(x.getIdEstacion() != 0){
			    paramAsigned++;
			    sbq.append(" and x.idEstacion = :idEstacion");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getCveProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.cveProveedor = :cveProveedor");
			}
			if(x.getRazonSocial() != null){
			    paramAsigned++;
			    sbq.append(" and x.razonSocial = :razonSocial");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Proveedor> nq = em.createQuery(sbq.toString(), Proveedor.class);
		
		if(paramAsigned>0){
			if(x.getIdProveedor() != null){
			    nq.setParameter("idProveedor",x.getIdProveedor());
			}
			if(x.getTipoProveedor() != null){
			    nq.setParameter("tipoProveedor",x.getTipoProveedor());
			}
			if(x.getIdEstacion() != (0) ){
			    nq.setParameter("idEstacion",x.getIdEstacion());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getCveProveedor() != null){
			    nq.setParameter("cveProveedor",x.getCveProveedor());
			}
			if(x.getRazonSocial() != null){
			    nq.setParameter("razonSocial",x.getRazonSocial());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Proveedor> findAll() {
		TypedQuery<Proveedor> nq = em.createNamedQuery("Proveedor.findAll", Proveedor.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Proveedor.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
