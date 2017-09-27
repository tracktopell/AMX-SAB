package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Master;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Stateless
public class MasterFacade extends AbstractFacade<Master> implements MasterFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MasterFacade() {
		super(Master.class);
	}

	@Override
	public List<Master> findAllLike(Master x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Master x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdKit() != null){
			    paramAsigned++;
			    sbq.append(" and x.idKit = :idKit");
			}
			if(x.getNombreEs() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEs = :nombreEs");
			}
			if(x.getNombreEn() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEn = :nombreEn");
			}
			if(x.getUrlMultimedia() != null){
			    paramAsigned++;
			    sbq.append(" and x.urlMultimedia = :urlMultimedia");
			}
			if(x.getContenedor() != null){
			    paramAsigned++;
			    sbq.append(" and x.contenedor = :contenedor");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			if(x.getnull() != null){
			    paramAsigned++;
			    sbq.append(" and x.null = :null");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Master> nq = em.createQuery(sbq.toString(), Master.class);
		
		if(paramAsigned>0){
			if(x.getIdKit() != null){
			    nq.setParameter("idKit",x.getIdKit());
			}
			if(x.getNombreEs() != null){
			    nq.setParameter("nombreEs",x.getNombreEs());
			}
			if(x.getNombreEn() != null){
			    nq.setParameter("nombreEn",x.getNombreEn());
			}
			if(x.getUrlMultimedia() != null){
			    nq.setParameter("urlMultimedia",x.getUrlMultimedia());
			}
			if(x.getContenedor() != null){
			    nq.setParameter("contenedor",x.getContenedor());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			if(x.getnull() != null){
			    nq.setParameter("null",x.getnull());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Master> findAll() {
		TypedQuery<Master> nq = em.createNamedQuery("Master.findAll", Master.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Master.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
