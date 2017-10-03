package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModuloPerfil;
import com.aeromexico.sab.backend.remote.ModuloPerfilFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table modulo_perfil.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */
@Stateless
public class ModuloPerfilFacade extends AbstractFacade<ModuloPerfil> implements ModuloPerfilFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ModuloPerfilFacade() {
		super(ModuloPerfil.class);
	}

	@Override
	public List<ModuloPerfil> findAllLike(ModuloPerfil x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ModuloPerfil x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getModuloPerfilPK() != null){
			    paramAsigned++;
			    sbq.append(" and x.moduloPerfilPK = :moduloPerfilPK");
			}
			if(x.getPermisoRwd() != null){
			    paramAsigned++;
			    sbq.append(" and x.permisoRwd = :permisoRwd");
			}
			if(x.getModulomodulo() != null){
			    paramAsigned++;
			    sbq.append(" and x.modulomodulo = :modulomodulo");
			}
			if(x.getPerfilperfil() != null){
			    paramAsigned++;
			    sbq.append(" and x.perfilperfil = :perfilperfil");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ModuloPerfil> nq = em.createQuery(sbq.toString(), ModuloPerfil.class);
		
		if(paramAsigned>0){
			if(x.getModuloPerfilPK() != null){
			    nq.setParameter("moduloPerfilPK",x.getModuloPerfilPK());
			}
			if(x.getPermisoRwd() != null){
			    nq.setParameter("permisoRwd",x.getPermisoRwd());
			}
			if(x.getModulomodulo() != null){
			    nq.setParameter("modulomodulo",x.getModulomodulo());
			}
			if(x.getPerfilperfil() != null){
			    nq.setParameter("perfilperfil",x.getPerfilperfil());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ModuloPerfil> findAll() {
		TypedQuery<ModuloPerfil> nq = em.createNamedQuery("ModuloPerfil.findAll", ModuloPerfil.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ModuloPerfil.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
