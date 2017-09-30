package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MODULO_PERFIL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class ModuloPerfilDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2093631819;

    
    /**
    * modulo perfil p k
    */
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfilid_perfil] int(0,0), [moduloid_modulo] int(0,0)]}
    
    /**
    * permiso rwd
    */
    private Short permisoRwd;
    
    /**
    * moduloid modulo
    */
    private Integer moduloidModulo;
    
    /**
    * perfilid perfil
    */
    private Integer perfilidPerfil;

    /** 
     * Default Constructor
     */
    public ModuloPerfilDTO() {
    }

    /**
     * Getters and Setters
     */
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfilid_perfil] int(0,0), [moduloid_modulo] int(0,0)]}
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfilid_perfil] int(0,0), [moduloid_modulo] int(0,0)]}
    public Short getPermisoRwd() {
        return this.permisoRwd;
    }
    public void setPermisoRwd(Short v) {
        this.permisoRwd = v;
    }
    public Integer getModuloidModulo() {
        return this.moduloidModulo;
    }
    public void setModuloidModulo(Integer v) {
        this.moduloidModulo = v;
    }
    public Integer getPerfilidPerfil() {
        return this.perfilidPerfil;
    }
    public void setPerfilidPerfil(Integer v) {
        this.perfilidPerfil = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(permisoRwd).hashCode();
		hash += String.valueOf(moduloidModulo).hashCode();
		hash += String.valueOf(perfilidPerfil).hashCode();
        return hash;
    }

	@Override
    public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}        
        if (!(o instanceof ModuloPerfilDTO)) {
            return false;
        }		
		ModuloPerfilDTO  other = (ModuloPerfilDTO ) o;
		if (!Objects.equals(this.permisoRwd, other.permisoRwd)) { return false; }		
		if (!Objects.equals(this.moduloidModulo, other.moduloidModulo)) { return false; }		
		if (!Objects.equals(this.perfilidPerfil, other.perfilidPerfil)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("permisoRwd", this.permisoRwd);
		jsonObj.put("moduloidModulo", this.moduloidModulo);
		jsonObj.put("perfilidPerfil", this.perfilidPerfil);
		return jsonObj.toString();
    }

	public static ModuloPerfilDTO create(String json) throws IllegalArgumentException{
		ModuloPerfilDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.permisoRwd = (short)(jObj.getInt("permisoRwd"));
		x.moduloidModulo = (jObj.getInt("moduloidModulo"));
		x.perfilidPerfil = (jObj.getInt("perfilidPerfil"));
		
		return x;
	}

}
