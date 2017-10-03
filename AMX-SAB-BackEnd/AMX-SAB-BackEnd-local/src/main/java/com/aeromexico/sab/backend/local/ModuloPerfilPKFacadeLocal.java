package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.ModuloPerfilPK;
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
public interface ModuloPerfilPKFacadeLocal {

	ModuloPerfilPK create(ModuloPerfilPK entity);

	ModuloPerfilPK edit(ModuloPerfilPK entity);

	void remove(ModuloPerfilPK entity);

	ModuloPerfilPK findByPK(Object id);

	List<ModuloPerfilPK> findAllLike(ModuloPerfilPK entity);

	List<ModuloPerfilPK> findAll();

	List<ModuloPerfilPK> findRange(int[] range);

	Long count();

	Long countAll();

}
