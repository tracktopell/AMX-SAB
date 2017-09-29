package com.aeromexico.sab.api;

import com.aeromexico.sab.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author alfredo
 */
public interface UsuarioService {
	public List<UsuarioDTO> getAll();
}
