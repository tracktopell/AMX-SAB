package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table CLASE.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/28 19:09
 */

public class ClaseDTO implements java.io.Serializable {
    private static final long serialVersionUID = 159413332;

    
    /**
    * id clase
    */
    private Integer idClase;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * clave
    */
    private String clave;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public ClaseDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdClase() {
        return this.idClase;
    }
    public void setIdClase(Integer v) {
        this.idClase = v;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String v) {
        this.nombre = v;
    }
    public String getClave() {
        return this.clave;
    }
    public void setClave(String v) {
        this.clave = v;
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
		hash += String.valueOf(idClase).hashCode();
		hash += String.valueOf(nombre).hashCode();
		hash += String.valueOf(clave).hashCode();
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
        if (!(o instanceof ClaseDTO)) {
            return false;
        }		
		ClaseDTO  other = (ClaseDTO ) o;
		if (!Objects.equals(this.idClase, other.idClase)) { return false; }		
		if (!Objects.equals(this.nombre, other.nombre)) { return false; }		
		if (!Objects.equals(this.clave, other.clave)) { return false; }		
		if (!Objects.equals(this.estatus, other.estatus)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idClase", this.idClase);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("clave", this.clave);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static ClaseDTO create(String json) throws IllegalArgumentException{
		ClaseDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idClase = (jObj.getInt("idClase"));
		x.nombre = (jObj.getString("nombre"));
		x.clave = (jObj.getString("clave"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
