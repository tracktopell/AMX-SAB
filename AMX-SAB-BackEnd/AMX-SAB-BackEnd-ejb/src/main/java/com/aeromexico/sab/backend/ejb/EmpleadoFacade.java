package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Empleado;
import com.aeromexico.sab.backend.remote.EmpleadoFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table empleado.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EmpleadoFacade() {
		super(Empleado.class);
	}

	@Override
	public List<Empleado> findAllLike(Empleado x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Empleado x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdEmpleado() != null){
			    paramAsigned++;
			    sbq.append(" and x.idEmpleado = :idEmpleado");
			}
			if(x.getUsuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuario = :usuario");
			}
			if(x.getCompania() != null){
			    paramAsigned++;
			    sbq.append(" and x.compania = :compania");
			}
			if(x.getArea() != null){
			    paramAsigned++;
			    sbq.append(" and x.area = :area");
			}
			if(x.getEstacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.estacion = :estacion");
			}
			if(x.getTelefono() != null){
			    paramAsigned++;
			    sbq.append(" and x.telefono = :telefono");
			}
			if(x.getExtension() != null){
			    paramAsigned++;
			    sbq.append(" and x.extension = :extension");
			}
			if(x.getDirectorioSab() != null){
			    paramAsigned++;
			    sbq.append(" and x.directorioSab = :directorioSab");
			}
			if(x.getEsatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.esatus = :esatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Empleado> nq = em.createQuery(sbq.toString(), Empleado.class);
		
		if(paramAsigned>0){
			if(x.getIdEmpleado() != null){
			    nq.setParameter("idEmpleado",x.getIdEmpleado());
			}
			if(x.getUsuario() != null){
			    nq.setParameter("usuario",x.getUsuario());
			}
			if(x.getCompania() != null){
			    nq.setParameter("compania",x.getCompania());
			}
			if(x.getArea() != null){
			    nq.setParameter("area",x.getArea());
			}
			if(x.getEstacion() != null){
			    nq.setParameter("estacion",x.getEstacion());
			}
			if(x.getTelefono() != null){
			    nq.setParameter("telefono",x.getTelefono());
			}
			if(x.getExtension() != null){
			    nq.setParameter("extension",x.getExtension());
			}
			if(x.getDirectorioSab() != null){
			    nq.setParameter("directorioSab",x.getDirectorioSab());
			}
			if(x.getEsatus() != null){
			    nq.setParameter("esatus",x.getEsatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Empleado> findAll() {
		TypedQuery<Empleado> nq = em.createNamedQuery("Empleado.findAll", Empleado.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Empleado.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
