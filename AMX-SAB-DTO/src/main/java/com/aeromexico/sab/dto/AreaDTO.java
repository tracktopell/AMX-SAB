package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table AREA.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class AreaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1867083167;

    
    /**
    * id area
    */
    private Integer idArea;
    
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
    public AreaDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdArea() {
        return this.idArea;
    }
    public void setIdArea(Integer v) {
        this.idArea = v;
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
		hash += String.valueOf(idArea).hashCode();
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
        if (!(o instanceof AreaDTO)) {
            return false;
        }		
		AreaDTO  other = (AreaDTO ) o;
		if (!Objects.equals(this.idArea, other.idArea)) { return false; }		
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
		jsonObj.put("idArea", this.idArea);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("clave", this.clave);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static AreaDTO create(String json) throws IllegalArgumentException{
		AreaDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idArea = (jObj.getInt("idArea"));
		x.nombre = (jObj.getString("nombre"));
		x.clave = (jObj.getString("clave"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
