package com.aeromexico.sab.backend.local;

import com.aeromexico.sab.backend.entity.EquipamientoComisariato;
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
public interface EquipamientoComisariatoFacadeLocal {

	EquipamientoComisariato create(EquipamientoComisariato entity);

	EquipamientoComisariato edit(EquipamientoComisariato entity);

	void remove(EquipamientoComisariato entity);

	EquipamientoComisariato findByPK(Object id);

	List<EquipamientoComisariato> findAllLike(EquipamientoComisariato entity);

	List<EquipamientoComisariato> findAll();

	List<EquipamientoComisariato> findRange(int[] range);

	Long count();

	Long countAll();

}
