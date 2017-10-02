package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.MaterialMasterPK;
import com.aeromexico.sab.backend.remote.MaterialMasterPKFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table material_master_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Stateless
public class MaterialMasterPKFacade extends AbstractFacade<MaterialMasterPK> implements MaterialMasterPKFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MaterialMasterPKFacade() {
		super(MaterialMasterPK.class);
	}

	@Override
	public List<MaterialMasterPK> findAllLike(MaterialMasterPK x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM MaterialMasterPK x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getNumeroParte() != null){
			    paramAsigned++;
			    sbq.append(" and x.numeroParte = :numeroParte");
			}
			if(x.getIdKit() != null){
			    paramAsigned++;
			    sbq.append(" and x.idKit = :idKit");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<MaterialMasterPK> nq = em.createQuery(sbq.toString(), MaterialMasterPK.class);
		
		if(paramAsigned>0){
			if(x.getNumeroParte() != null){
			    nq.setParameter("numeroParte",x.getNumeroParte());
			}
			if(x.getIdKit() != null){
			    nq.setParameter("idKit",x.getIdKit());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<MaterialMasterPK> findAll() {
		TypedQuery<MaterialMasterPK> nq = em.createNamedQuery("MaterialMasterPK.findAll", MaterialMasterPK.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("MaterialMasterPK.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
