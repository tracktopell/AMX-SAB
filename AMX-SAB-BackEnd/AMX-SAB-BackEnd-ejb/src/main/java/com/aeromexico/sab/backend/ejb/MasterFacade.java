package com.aeromexico.sab.backend.ejb;

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
 * @version 1.13.1
 * @date 2017/09/30 07:39
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
			if(x.getIdUnidadMedida() != null){
			    paramAsigned++;
			    sbq.append(" and x.idUnidadMedida = :idUnidadMedida");
			}
			if(x.getIdInstruccionesNacionales() != null){
			    paramAsigned++;
			    sbq.append(" and x.idInstruccionesNacionales = :idInstruccionesNacionales");
			}
			if(x.getIdInstruccionesInternac() != null){
			    paramAsigned++;
			    sbq.append(" and x.idInstruccionesInternac = :idInstruccionesInternac");
			}
			if(x.getIdTipoKit() != null){
			    paramAsigned++;
			    sbq.append(" and x.idTipoKit = :idTipoKit");
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
			if(x.getIdUnidadMedida() != null){
			    nq.setParameter("idUnidadMedida",x.getIdUnidadMedida());
			}
			if(x.getIdInstruccionesNacionales() != null){
			    nq.setParameter("idInstruccionesNacionales",x.getIdInstruccionesNacionales());
			}
			if(x.getIdInstruccionesInternac() != null){
			    nq.setParameter("idInstruccionesInternac",x.getIdInstruccionesInternac());
			}
			if(x.getIdTipoKit() != null){
			    nq.setParameter("idTipoKit",x.getIdTipoKit());
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
