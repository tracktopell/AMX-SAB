package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table PERFIL.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class PerfilDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2093176254;

    
    /**
    * id perfil
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idPerfil
    private Integer idPerfil;
    
    /**
    * nombre
    */
    // Simple: PK?false, FK?false, class=java.lang.String, o=nombre
    private String nombre;
    
    /**
    * estatus
    */
    // Simple: PK?false, FK?false, class=java.lang.Short, o=estatus
    private Short estatus;

    /** 
     * Default Constructor
     */
    public PerfilDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdPerfil() {
        return this.idPerfil;
    }
    public void setIdPerfil(Integer v) {
        this.idPerfil = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public Short getEstatus() {
        return this.estatus;
    }
    public void setEstatus(Short v) {
        this.estatus = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idPerfil).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(estatus).hashCode();
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
        if (!(o instanceof PerfilDTO)) {
            return false;
        }		
		PerfilDTO  other = (PerfilDTO ) o;
		if (!Objects.equals(this.idPerfil, other.idPerfil)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idPerfil", this.idPerfil);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static PerfilDTO create(String json) throws IllegalArgumentException{
		PerfilDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idPerfil = (jObj.getInt("idPerfil"));
		x.nombre = (jObj.getString("nombre"));
		x.estatus = (jObj.getShort("estatus"));
		
		return x;
	}

}
