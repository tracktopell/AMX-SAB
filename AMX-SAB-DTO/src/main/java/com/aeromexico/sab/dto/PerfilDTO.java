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
 * @version 1.14.1
 * @date 2017/10/04 07:27
 */

public class PerfilDTO implements java.io.Serializable {
    private static final long serialVersionUID = 2093176254;

    
    /**
    * perfil
    */
    private String perfil;
    
    /**
    * descripcion
    */
    private String descripcion;

    /** 
     * Default Constructor
     */
    public PerfilDTO() {
    }

    /**
     * Getters and Setters
     */
    public String getPerfil() {
        return this.perfil;
    }
    public void setPerfil(String v) {
        this.perfil = v;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String v) {
        this.descripcion = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(perfil).hashCode();
		hash += String.valueOf(descripcion).hashCode();
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
		if (!Objects.equals(this.perfil, other.perfil)) { return false; }		
		if (!Objects.equals(this.descripcion, other.descripcion)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("perfil", this.perfil);
		jsonObj.put("descripcion", this.descripcion);
		return jsonObj.toString();
    }

	public static PerfilDTO create(String json) throws IllegalArgumentException{
		PerfilDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.perfil = (jObj.getString("perfil"));
		x.descripcion = (jObj.getString("descripcion"));
		
		return x;
	}

}
