package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table REGION.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.13.1
 * @date 2017/09/30 07:39
 */

public class RegionDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1160460865;

    
    /**
    * id region
    */
    private Integer idRegion;
    
    /**
    * cve region
    */
    private String cveRegion;
    
    /**
    * nombre
    */
    private String nombre;
    
    /**
    * estatus
    */
    private Short estatus;

    /** 
     * Default Constructor
     */
    public RegionDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdRegion() {
        return this.idRegion;
    }
    public void setIdRegion(Integer v) {
        this.idRegion = v;
    }
    public String getCveRegion() {
        return this.cveRegion;
    }
    public void setCveRegion(String v) {
        this.cveRegion = v;
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
		hash += String.valueOf(idRegion).hashCode();
		hash += String.valueOf(cveRegion).hashCode();
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
        if (!(o instanceof RegionDTO)) {
            return false;
        }		
		RegionDTO  other = (RegionDTO ) o;
		if (!Objects.equals(this.idRegion, other.idRegion)) { return false; }		
		if (!Objects.equals(this.cveRegion, other.cveRegion)) { return false; }		
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
		jsonObj.put("idRegion", this.idRegion);
		jsonObj.put("cveRegion", this.cveRegion);
		jsonObj.put("nombre", this.nombre);
		jsonObj.put("estatus", this.estatus);
		return jsonObj.toString();
    }

	public static RegionDTO create(String json) throws IllegalArgumentException{
		RegionDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idRegion = (jObj.getInt("idRegion"));
		x.cveRegion = (jObj.getString("cveRegion"));
		x.nombre = (jObj.getString("nombre"));
		x.estatus = (short)(jObj.getInt("estatus"));
		
		return x;
	}

}
