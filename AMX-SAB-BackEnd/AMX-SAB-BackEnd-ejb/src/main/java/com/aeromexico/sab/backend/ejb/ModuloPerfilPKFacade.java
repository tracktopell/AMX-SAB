package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModuloPerfilPK;
import com.aeromexico.sab.backend.remote.ModuloPerfilPKFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table modulo_perfil_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class ModuloPerfilPKFacade extends AbstractFacade<ModuloPerfilPK> implements ModuloPerfilPKFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ModuloPerfilPKFacade() {
		super(ModuloPerfilPK.class);
	}

	@Override
	public List<ModuloPerfilPK> findAllLike(ModuloPerfilPK x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ModuloPerfilPK x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getIdModulo() != null){
			    paramAsigned++;
			    sbq.append(" and x.idModulo = :idModulo");
			}
			if(x.getPerfil() != null){
			    paramAsigned++;
			    sbq.append(" and x.perfil = :perfil");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ModuloPerfilPK> nq = em.createQuery(sbq.toString(), ModuloPerfilPK.class);
		
		if(paramAsigned>0){
			if(x.getIdModulo() != null){
			    nq.setParameter("idModulo",x.getIdModulo());
			}
			if(x.getPerfil() != null){
			    nq.setParameter("perfil",x.getPerfil());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ModuloPerfilPK> findAll() {
		TypedQuery<ModuloPerfilPK> nq = em.createNamedQuery("ModuloPerfilPK.findAll", ModuloPerfilPK.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ModuloPerfilPK.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
