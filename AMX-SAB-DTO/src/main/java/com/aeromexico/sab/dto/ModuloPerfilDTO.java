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
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class ModuloPerfilDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2093631819;

    
    /**
    * modulo perfil p k
    */
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfil] varchar(50,0), [id_modulo] int(0,0)]}
    
    /**
    * permiso rwd
    */
    private Short permisoRwd;
    
    /**
    * id modulo
    */
    private Integer idModulo;
    
    /**
    * perfil
    */
    private String perfil;

    /** 
     * Default Constructor
     */
    public ModuloPerfilDTO() {
    }

    /**
     * Getters and Setters
     */
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfil] varchar(50,0), [id_modulo] int(0,0)]}
    // moduloPerfilPK EmbedableColumn ID References: FKs {[[perfil] varchar(50,0), [id_modulo] int(0,0)]}
    public Short getPermisoRwd() {
        return this.permisoRwd;
    }
    public void setPermisoRwd(Short v) {
        this.permisoRwd = v;
    }
    public Integer getIdModulo() {
        return this.idModulo;
    }
    public void setIdModulo(Integer v) {
        this.idModulo = v;
    }
    public String getPerfil() {
        return this.perfil;
    }
    public void setPerfil(String v) {
        this.perfil = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(permisoRwd).hashCode();
		hash += String.valueOf(idModulo).hashCode();
		hash += String.valueOf(perfil).hashCode();
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
		if (!Objects.equals(this.idModulo, other.idModulo)) { return false; }		
		if (!Objects.equals(this.perfil, other.perfil)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("permisoRwd", this.permisoRwd);
		jsonObj.put("idModulo", this.idModulo);
		jsonObj.put("perfil", this.perfil);
		return jsonObj.toString();
    }

	public static ModuloPerfilDTO create(String json) throws IllegalArgumentException{
		ModuloPerfilDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.permisoRwd = (short)(jObj.getInt("permisoRwd"));
		x.idModulo = (jObj.getInt("idModulo"));
		x.perfil = (jObj.getString("perfil"));
		
		return x;
	}

}
