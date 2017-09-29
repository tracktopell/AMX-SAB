package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.ContactoProveedorEstacion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table contacto_proveedor_estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
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
			if(x.getProveedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.proveedor = :proveedor");
			}
			if(x.getEstacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.estacion = :estacion");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getEmail() != null){
			    paramAsigned++;
			    sbq.append(" and x.email = :email");
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
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getUsuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuario = :usuario");
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
			if(x.getProveedor() != null){
			    nq.setParameter("proveedor",x.getProveedor());
			}
			if(x.getEstacion() != null){
			    nq.setParameter("estacion",x.getEstacion());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getEmail() != null){
			    nq.setParameter("email",x.getEmail());
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
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getUsuario() != null){
			    nq.setParameter("usuario",x.getUsuario());
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
