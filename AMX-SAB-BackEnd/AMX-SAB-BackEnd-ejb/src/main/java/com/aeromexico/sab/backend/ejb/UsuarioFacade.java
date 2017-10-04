package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.Usuario;
import com.aeromexico.sab.backend.remote.UsuarioFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table usuario.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {

	@PersistenceContext(unitName = "AMX_SAB_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	public List<Usuario> findAllLike(Usuario x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Usuario x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getEmailUsuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.emailUsuario = :emailUsuario");
			}
			if(x.getContrasenia() != null){
			    paramAsigned++;
			    sbq.append(" and x.contrasenia = :contrasenia");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getApellidoPaterno() != null){
			    paramAsigned++;
			    sbq.append(" and x.apellidoPaterno = :apellidoPaterno");
			}
			if(x.getApellidoMaterno() != null){
			    paramAsigned++;
			    sbq.append(" and x.apellidoMaterno = :apellidoMaterno");
			}
			if(x.getEstatus() != null){
			    paramAsigned++;
			    sbq.append(" and x.estatus = :estatus");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Usuario> nq = em.createQuery(sbq.toString(), Usuario.class);
		
		if(paramAsigned>0){
			if(x.getEmailUsuario() != null){
			    nq.setParameter("emailUsuario",x.getEmailUsuario());
			}
			if(x.getContrasenia() != null){
			    nq.setParameter("contrasenia",x.getContrasenia());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getApellidoPaterno() != null){
			    nq.setParameter("apellidoPaterno",x.getApellidoPaterno());
			}
			if(x.getApellidoMaterno() != null){
			    nq.setParameter("apellidoMaterno",x.getApellidoMaterno());
			}
			if(x.getEstatus() != null){
			    nq.setParameter("estatus",x.getEstatus());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Usuario> findAll() {
		TypedQuery<Usuario> nq = em.createNamedQuery("Usuario.findAll", Usuario.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Usuario.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
