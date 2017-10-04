package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Estacion;
import com.aeromexico.sab.backend.remote.EstacionFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table estacion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class EstacionFacade extends AbstractFacade<Estacion> implements EstacionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EstacionFacade() {
		super(Estacion.class);
	}

	@Override
	public List<Estacion> findAllLike(Estacion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Estacion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdEstacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idEstacion = :idEstacion");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getClaveIata() != null){
			    paramAsigned++;
			    sbq.append(" and x.claveIata = :claveIata");
			}
			if(x.getCiudad() != null){
			    paramAsigned++;
			    sbq.append(" and x.ciudad = :ciudad");
			}
			if(x.getObservaciones() != null){
			    paramAsigned++;
			    sbq.append(" and x.observaciones = :observaciones");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Estacion> nq = em.createQuery(sbq.toString(), Estacion.class);
		
		if(paramAsigned>0){
			if(x.getIdEstacion() != null){
			    nq.setParameter("idEstacion",x.getIdEstacion());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getClaveIata() != null){
			    nq.setParameter("claveIata",x.getClaveIata());
			}
			if(x.getCiudad() != null){
			    nq.setParameter("ciudad",x.getCiudad());
			}
			if(x.getObservaciones() != null){
			    nq.setParameter("observaciones",x.getObservaciones());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Estacion> findAll() {
		TypedQuery<Estacion> nq = em.createNamedQuery("Estacion.findAll", Estacion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Estacion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
