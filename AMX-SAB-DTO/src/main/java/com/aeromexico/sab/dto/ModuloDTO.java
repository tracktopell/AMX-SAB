package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table MODULO.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/03 13:52
 */

public class ModuloDTO implements java.io.Serializable {
    private static final long serialVersionUID = 189568618;

    
    /**
    * id modulo
    */
    private Integer idModulo;
    
    /**
    * id modulo padre
    */
    private int idModuloPadre;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * uri
    */
    private String uri;

    /** 
     * Default Constructor
     */
    public ModuloDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdModulo() {
        return this.idModulo;
    }
    public void setIdModulo(Integer v) {
        this.idModulo = v;
    }
    public int getIdModuloPadre() {
        return this.idModuloPadre;
    }
    public void setIdModuloPadre(int v) {
        this.idModuloPadre = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getUri() {
        return this.uri;
    }
    public void setUri(String v) {
        this.uri = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idModulo).hashCode();
		hash += String.valueOf(idModuloPadre).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(uri).hashCode();
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
        if (!(o instanceof ModuloDTO)) {
            return false;
        }		
		ModuloDTO  other = (ModuloDTO ) o;
		if (!Objects.equals(this.idModulo, other.idModulo)) { return false; }		
		if (!Objects.equals(this.idModuloPadre, other.idModuloPadre)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.uri, other.uri)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idModulo", this.idModulo);
		jsonObj.put("idModuloPadre", this.idModuloPadre);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("uri", this.uri);
		return jsonObj.toString();
    }

	public static ModuloDTO create(String json) throws IllegalArgumentException{
		ModuloDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idModulo = (jObj.getInt("idModulo"));
		x.idModuloPadre = (jObj.getInt("idModuloPadre"));
		x.nombre = (jObj.getString("nombre"));
		x.uri = (jObj.getString("uri"));
		
		return x;
	}

}
