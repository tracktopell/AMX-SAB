package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 * JPA Entity @Local Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/02 18:43
 */
@Local
public interface UsuarioFacadeLocal {

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
