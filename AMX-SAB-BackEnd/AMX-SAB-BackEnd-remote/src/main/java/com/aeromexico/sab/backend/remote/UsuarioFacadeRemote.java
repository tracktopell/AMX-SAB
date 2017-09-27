package com.aeromexico.sab.backend.remote;

import com.aeromexico.sab.backend.entity.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */
@Remote
public interface UsuarioFacadeRemote {

	Usuario create(Usuario entity);

	Usuario edit(Usuario entity);

	void remove(Usuario entity);

	Usuario findByPK(Object id);

	List<Usuario> findAllLike(Usuario entity);

	List<Usuario> findAll();

	List<Usuario> findRange(int[] range);

	Long count();

	Long countAll();

}
