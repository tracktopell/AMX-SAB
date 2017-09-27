package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.CodigoServicio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table codigo_servicio.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class CodigoServicioFacade extends AbstractFacade<CodigoServicio> implements CodigoServicioFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CodigoServicioFacade() {
		super(CodigoServicio.class);
	}

	@Override
	public List<CodigoServicio> findAllLike(CodigoServicio x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM CodigoServicio x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdCodigoServicio() != null){
			    paramAsigned++;
			    sbq.append(" and x.idCodigoServicio = :idCodigoServicio");
			}
			if(x.getCveCodigoServicio() != null){
			    paramAsigned++;
			    sbq.append(" and x.cveCodigoServicio = :cveCodigoServicio");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<CodigoServicio> nq = em.createQuery(sbq.toString(), CodigoServicio.class);
		
		if(paramAsigned>0){
			if(x.getIdCodigoServicio() != null){
			    nq.setParameter("idCodigoServicio",x.getIdCodigoServicio());
			}
			if(x.getCveCodigoServicio() != null){
			    nq.setParameter("cveCodigoServicio",x.getCveCodigoServicio());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<CodigoServicio> findAll() {
		TypedQuery<CodigoServicio> nq = em.createNamedQuery("CodigoServicio.findAll", CodigoServicio.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("CodigoServicio.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
