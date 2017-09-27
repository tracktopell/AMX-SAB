package com.aeromexico.sab.dto;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for mapping Json DTO Entity of Table AVION_CAPACIDAD.
 * 
 * Json Serialization / Deserialization JSE/Android ready compatible.
 * @See https://developer.android.com/reference/org/json/JSONObject.html
 * @See https://stleary.github.io/JSON-java/
 *
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.9
 * @date 2017/09/27 07:01
 */

public class AvionCapacidadDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1023892928;

    
    /**
    * id avion capacidad
    */
    // Simple: PK?true, FK?false, class=java.lang.Integer, o=idAvionCapacidad
    private Integer idAvionCapacidad;
    
    /**
    * id avion
    */
    // Simple: PK?false, FK?true, class=int, o=idAvion
    private int idAvion;
    
    /**
    * id clase
    */
    // Simple: PK?false, FK?true, class=int, o=idClase
    private int idClase;
    
    /**
    * capacidad
    */
    // Simple: PK?false, FK?false, class=int, o=capacidad
    private int capacidad;

    /** 
     * Default Constructor
     */
    public AvionCapacidadDTO() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdAvionCapacidad() {
        return this.idAvionCapacidad;
    }
    public void setIdAvionCapacidad(Integer v) {
        this.idAvionCapacidad = v;
    }
    public int getIdAvion() {
        return this.idAvion;
    }
    public void setIdAvion(int v) {
        this.idAvion = v;
    }
    public int getIdClase() {
        return this.idClase;
    }
    public void setIdClase(int v) {
        this.idClase = v;
    }
    public int getCapacidad() {
        return this.capacidad;
    }
    public void setCapacidad(int v) {
        this.capacidad = v;
    }

    @Override
    public int hashCode() {
        int hash = 0;
		hash += String.valueOf(idAvionCapacidad).hashCode();
		hash += String.valueOf(idAvion).hashCode();
		hash += String.valueOf(idClase).hashCode();
		hash += String.valueOf(capacidad).hashCode();
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
        if (!(o instanceof AvionCapacidadDTO)) {
            return false;
        }		
		AvionCapacidadDTO  other = (AvionCapacidadDTO ) o;
		if (!Objects.equals(this.idAvionCapacidad, other.idAvionCapacidad)) { return false; }		
		if (!Objects.equals(this.idAvion, other.idAvion)) { return false; }		
		if (!Objects.equals(this.idClase, other.idClase)) { return false; }		
		if (!Objects.equals(this.capacidad, other.capacidad)) { return false; }		
    	return true;
    }

	/**
    * @Returns JSon String
    */
    @Override
    public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("idAvionCapacidad", this.idAvionCapacidad);
		jsonObj.put("idAvion", this.idAvion);
		jsonObj.put("idClase", this.idClase);
		jsonObj.put("capacidad", this.capacidad);
		return jsonObj.toString();
    }

	public static AvionCapacidadDTO create(String json) throws IllegalArgumentException{
		AvionCapacidadDTO x = null;
		JSONObject jObj = new JSONObject(json);
		
		x.idAvionCapacidad = (jObj.getInt("idAvionCapacidad"));
		x.idAvion = (jObj.getInt("idAvion"));
		x.idClase = (jObj.getInt("idClase"));
		x.capacidad = (jObj.getInt("capacidad"));
		
		return x;
	}

}
