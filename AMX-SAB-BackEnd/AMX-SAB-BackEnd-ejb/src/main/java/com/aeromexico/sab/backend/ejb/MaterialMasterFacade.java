package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.MaterialMaster;
import com.aeromexico.sab.backend.remote.MaterialMasterFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table material_master.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class MaterialMasterFacade extends AbstractFacade<MaterialMaster> implements MaterialMasterFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MaterialMasterFacade() {
		super(MaterialMaster.class);
	}

	@Override
	public List<MaterialMaster> findAllLike(MaterialMaster x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM MaterialMaster x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getMaterialMasterPK() != null){
			    paramAsigned++;
			    sbq.append(" and x.materialMasterPK = :materialMasterPK");
			}
			if(x.getCantidad()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.cantidad = :cantidad");
			}
			if(x.getPeso()  != 0.0f){
			    paramAsigned++;
			    sbq.append(" and x.peso = :peso");
			}
			if(x.getIdUnidadMedida() != null){
			    paramAsigned++;
			    sbq.append(" and x.idUnidadMedida = :idUnidadMedida");
			}
			if(x.getObservaciones() != null){
			    paramAsigned++;
			    sbq.append(" and x.observaciones = :observaciones");
			}
			if(x.getMaterial() != null){
			    paramAsigned++;
			    sbq.append(" and x.material = :material");
			}
			if(x.getMaster() != null){
			    paramAsigned++;
			    sbq.append(" and x.master = :master");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<MaterialMaster> nq = em.createQuery(sbq.toString(), MaterialMaster.class);
		
		if(paramAsigned>0){
			if(x.getMaterialMasterPK() != null){
			    nq.setParameter("materialMasterPK",x.getMaterialMasterPK());
			}
			if(x.getCantidad()  != 0){
			    nq.setParameter("cantidad",x.getCantidad());
			}
			if(x.getPeso()  != 0.0f){
			    nq.setParameter("peso",x.getPeso());
			}
			if(x.getIdUnidadMedida() != null){
			    nq.setParameter("idUnidadMedida",x.getIdUnidadMedida());
			}
			if(x.getObservaciones() != null){
			    nq.setParameter("observaciones",x.getObservaciones());
			}
			if(x.getMaterial() != null){
			    nq.setParameter("material",x.getMaterial());
			}
			if(x.getMaster() != null){
			    nq.setParameter("master",x.getMaster());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<MaterialMaster> findAll() {
		TypedQuery<MaterialMaster> nq = em.createNamedQuery("MaterialMaster.findAll", MaterialMaster.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("MaterialMaster.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
