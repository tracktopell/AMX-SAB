package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModeloAvion;
import com.aeromexico.sab.backend.remote.ModeloAvionFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table modelo_avion.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class ModeloAvionFacade extends AbstractFacade<ModeloAvion> implements ModeloAvionFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ModeloAvionFacade() {
		super(ModeloAvion.class);
	}

	@Override
	public List<ModeloAvion> findAllLike(ModeloAvion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ModeloAvion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdModeloAvion() != null){
			    paramAsigned++;
			    sbq.append(" and x.idModeloAvion = :idModeloAvion");
			}
			if(x.getModelo() != null){
			    paramAsigned++;
			    sbq.append(" and x.modelo = :modelo");
			}
			if(x.getDescripcion() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcion = :descripcion");
			}
			if(x.getTipoCabina() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipoCabina = :tipoCabina");
			}
			if(x.getCompania() != null){
			    paramAsigned++;
			    sbq.append(" and x.compania = :compania");
			}
			if(x.getIdFabricante() != null){
			    paramAsigned++;
			    sbq.append(" and x.idFabricante = :idFabricante");
			}
			if(x.getEstaus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estaus = :estaus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ModeloAvion> nq = em.createQuery(sbq.toString(), ModeloAvion.class);
		
		if(paramAsigned>0){
			if(x.getIdModeloAvion() != null){
			    nq.setParameter("idModeloAvion",x.getIdModeloAvion());
			}
			if(x.getModelo() != null){
			    nq.setParameter("modelo",x.getModelo());
			}
			if(x.getDescripcion() != null){
			    nq.setParameter("descripcion",x.getDescripcion());
			}
			if(x.getTipoCabina() != null){
			    nq.setParameter("tipoCabina",x.getTipoCabina());
			}
			if(x.getCompania() != null){
			    nq.setParameter("compania",x.getCompania());
			}
			if(x.getIdFabricante() != null){
			    nq.setParameter("idFabricante",x.getIdFabricante());
			}
			if(x.getEstaus() != null){
			    nq.setParameter("estaus",x.getEstaus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ModeloAvion> findAll() {
		TypedQuery<ModeloAvion> nq = em.createNamedQuery("ModeloAvion.findAll", ModeloAvion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ModeloAvion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
