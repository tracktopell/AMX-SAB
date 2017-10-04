package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ContactoProveedorEstacion;
import com.aeromexico.sab.backend.remote.ContactoProveedorEstacionFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table contacto_proveedor_estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class ContactoProveedorEstacionFacade extends AbstractFacade<ContactoProveedorEstacion> implements ContactoProveedorEstacionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ContactoProveedorEstacionFacade() {
		super(ContactoProveedorEstacion.class);
	}

	@Override
	public List<ContactoProveedorEstacion> findAllLike(ContactoProveedorEstacion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ContactoProveedorEstacion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getUsuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuario = :usuario");
			}
			if(x.getProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.proveedor = :proveedor");
			}
			if(x.getEstacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.estacion = :estacion");
			}
			if(x.getTelefono() != null){
			    paramAsigned++;
			    sbq.append(" and x.telefono = :telefono");
			}
			if(x.getExtencion() != null){
			    paramAsigned++;
			    sbq.append(" and x.extencion = :extencion");
			}
			if(x.getPuestoAreaEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.puestoAreaEn = :puestoAreaEn");
			}
			if(x.getPuestoAreaEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.puestoAreaEs = :puestoAreaEs");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ContactoProveedorEstacion> nq = em.createQuery(sbq.toString(), ContactoProveedorEstacion.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getUsuario() != null){
			    nq.setParameter("usuario",x.getUsuario());
			}
			if(x.getProveedor() != null){
			    nq.setParameter("proveedor",x.getProveedor());
			}
			if(x.getEstacion() != null){
			    nq.setParameter("estacion",x.getEstacion());
			}
			if(x.getTelefono() != null){
			    nq.setParameter("telefono",x.getTelefono());
			}
			if(x.getExtencion() != null){
			    nq.setParameter("extencion",x.getExtencion());
			}
			if(x.getPuestoAreaEn() != null){
			    nq.setParameter("puestoAreaEn",x.getPuestoAreaEn());
			}
			if(x.getPuestoAreaEs() != null){
			    nq.setParameter("puestoAreaEs",x.getPuestoAreaEs());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ContactoProveedorEstacion> findAll() {
		TypedQuery<ContactoProveedorEstacion> nq = em.createNamedQuery("ContactoProveedorEstacion.findAll", ContactoProveedorEstacion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ContactoProveedorEstacion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
