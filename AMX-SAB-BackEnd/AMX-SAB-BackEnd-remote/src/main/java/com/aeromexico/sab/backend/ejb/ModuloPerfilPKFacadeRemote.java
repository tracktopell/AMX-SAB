package com.aeromexico.sab.backend.ejb;

import com.aeromexico.sab.backend.entity.ModuloPerfilPK;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */
@Remote
public interface ModuloPerfilPKFacadeRemote {

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
